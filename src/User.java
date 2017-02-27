import java.util.HashMap;


public class User{

	private String userName;
	private int count;
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User(String name, int id ,int viewCount){
		setUserName(name);
		userId=id;
		setCount(viewCount);
	}
	
	public int hashCode(){
		return userId;
	}

	public boolean equals (Object obj){
		User user = (User) obj;
		return user.userId==userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
