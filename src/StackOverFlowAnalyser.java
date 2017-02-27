import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;


public class StackOverFlowAnalyser {
	private static Map<String,Answers> answers;
	private static Map<String,String> dictionary;
	private static Map<String,Post> posts;
	private static MostPopularCache answerCache;
	private static MostPopularCache acceptedCache;

	public StackOverFlowAnalyser(){
		
		//Create Data strucutres
		
		//Key : ID of the user, Value : Answers Obkect - count of accepted and answered question by that ID
		answers = new HashMap<String, Answers>();
		
		//Key : ID of the user , Value : Display name of the User
		dictionary=new HashMap<String, String>();
		
		//Key : Id of the post, Value : Post Object - postId, type, owner, acceptedId
		posts = new HashMap<String, Post>();
		
		//caches top 10 most used user when finding answers
		answerCache=new MostPopularCache(10);
		
		//caches top 10 most used users when finding accepted answers
		acceptedCache=new MostPopularCache(10);
		
	}
	
	public void run() throws FileNotFoundException, IOException {
		
		//read user xml (unmodified from the original version)
		readUsers("users-short.xml");
		
		//read Post xml (unmodified from the original version)
		readPosts("posts-short.xml");
		
		//Analyse the post data
		parsePosts();
		
		System.out.println("Top 10 users with the most answers:");
		
		//print caches respectively
		
		answerCache.printCacheElements();
		System.out.println("Top 10 users with the most accepted answers:");
		acceptedCache.printCacheElements();
		
	}

	public static String parseFieldFromLine(String line, String key) {
		// We're looking for a thing that looks like:
		// [key]="[value]"
		// as part of a larger String.
		// We are given [key], and want to return [value].

		// Find the start of the pattern
		String keyPattern = key + "=\"";
		int idx = line.indexOf(keyPattern);

		// No match
		if (idx == -1) return "";

		// Find the closing quote at the end of the pattern
		int start = idx + keyPattern.length();

		int end = start;
		while (line.charAt(end) != '"') {
			end++;
		}

		// Extract [value] from the overall String and return it
		return line.substring(start, end);
	}

	public static void readUsers(String filename) throws FileNotFoundException, IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(filename), Charset.forName("UTF-8")));
		String line;
		while ((line = b.readLine()) != null) {
			dictionary.put(parseFieldFromLine(line, "Id"),parseFieldFromLine(line, "DisplayName"));
		}
	}

	public static void readPosts(String filename) throws FileNotFoundException, IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(filename), Charset.forName("UTF-8")));
		String line=null;
		String Id=null;
		String postTypeId=null;
		String ownerUserId=null;
		String acceptedAnswerId=null;
		Post post;
		while ((line = b.readLine()) != null) {
			Id = parseFieldFromLine(line, "Id");
			postTypeId=parseFieldFromLine(line, "PostTypeId");
			ownerUserId=parseFieldFromLine(line, "OwnerUserId");
			acceptedAnswerId=parseFieldFromLine(line, "AcceptedAnswerId");
			post = new Post(Id, postTypeId, ownerUserId, acceptedAnswerId);
			posts.put(Id, post);
		}
	}

	public static void parsePosts(){
		String Id=null;
		String postTypeId=null;
		String ownerUserId=null;
		String acceptedAnswerId=null;
		Answers answer;
		for(Post post :posts.values()){
			
			Id = post.getId();
			postTypeId=post.getPostTypeId();
			ownerUserId=post.getOwnerUserId();
			acceptedAnswerId=post.getAcceptedAnswerId();
			
			if(post.postTypeId.equals("2")&& Id!=null){
				
				if(answers.containsKey(ownerUserId)){
					answer=answers.get(ownerUserId);
					answer.setAnswered(answer.getAnswered()+1);
					answers.put(ownerUserId, answer);
				}
				else{
					answer=new Answers(1, 0);
					answers.put(ownerUserId, answer);
				}
				User tmp=new User(dictionary.get(ownerUserId),Integer.valueOf(ownerUserId),answers.get(ownerUserId).getAnswered());
				answerCache.addToCache(tmp);

			}
			if(postTypeId.equals("1") && !acceptedAnswerId.equals("") && Id!=null){
				String postId = post.getAcceptedAnswerId();
				String acceptedOwnerId=posts.get(postId).getOwnerUserId();
				if(answers.containsKey(acceptedOwnerId)){
					answer=answers.get(acceptedOwnerId);
					answer.setAccepted(answer.getAccepted()+1);
					answers.put(acceptedOwnerId, answer);
				}
				else{
					answer=new Answers(0, 1);
					answers.put(acceptedOwnerId, answer);
				}
				User tmp=new User(dictionary.get(acceptedOwnerId),Integer.valueOf(acceptedOwnerId),answers.get(acceptedOwnerId).getAccepted());
				
				acceptedCache.addToCache(tmp);
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException  {
		long startTime = System.nanoTime();
		StackOverFlowAnalyser analyser= new StackOverFlowAnalyser();
		analyser.run();
		long enddTime = System.nanoTime();
        System.out.println( "Total Time taken for Analysis: "+ (enddTime-startTime));

	}

}
