import java.util.HashMap;


public class CheckUser {

	public static void main(String[] args) {
//		HashMap<User, String> user = new HashMap<User, String>();
//		user.put(new User("Anandan",1,1), "1 user");
//		user.put(new User("Anandan",2,1), "2 user");
//		user.put(new User("Anandan",3,1), "3 user");
//		user.put(new User("Anandan",4,1), "4 user");
//		user.put(new User("Anandan",5,1), "5 user");
//		user.put(new User("Anandan",6,1), "6 user");
//		
//		//System.out.println(user.containsKey(new User("asdd",1,3)));
	
		User user1 = new User("BCDEF",3,4);
		User user2 = new User("fsaf",4,6);
		User user3 = new User("Anandan",1,2);
		User user4 = new User("chelse",2,4);
		User user5 = new User("utyyj",5,4);
		User user6 = new User("nvbmv",6,1);
		User user7 = new User("Anandan",1,9);
		User user8 = new User("nvbmv",6,14);
		User user9 = new User("utyyj",5,18);
//		
		MostPopularCache cache = new MostPopularCache(3);
//		
//		DoubleLinkedList list = new DoubleLinkedList();
//		System.out.println(user1.getUserName());
//		list.add(user1);
//		list.add(user2);
//		System.out.println(user1.getUserName());		
//		list1.add(user1.getUserName(),user1.getUserId(),user1.getCount());
//		list1.add(user2.getUserName(),user2.getUserId(),user2.getCount());
//		list1.add(user2.getUserName(),user3.getUserId(),user3.getCount());
//		list.add(user3);
//		list.add(user4);
//		list.add(user5);
//		list.add(user6);
		cache.addToCache(user1);
		cache.printCacheElements();
		cache.addToCache(user2);
		cache.printCacheElements();
		cache.addToCache(user3);
		cache.printCacheElements();
		cache.addToCache(user4);
		cache.printCacheElements();
		cache.addToCache(user5);
		cache.printCacheElements();
		cache.addToCache(user6);
		cache.printCacheElements();
		cache.addToCache(user2);
		cache.printCacheElements();
		cache.addToCache(user1);
		
		cache.printCacheElements();
		cache.addToCache(user7);
		cache.printCacheElements();
		cache.addToCache(user8);
//		cache.printCacheElements();
		cache.addToCache(user9);
//		
//		list.printList();
//		
		cache.printCacheElements();
		System.out.println(cache.getList().getBottom().getUserMap().getUserName());
		
	}
}
