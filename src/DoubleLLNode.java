// Author : Anandan
public class DoubleLLNode {
	private User userMap;
	private DoubleLLNode previous;
	private DoubleLLNode next;
	public DoubleLLNode(User user){
		userMap = new User(user.getUserName(),user.getUserId(), user.getCount());
		previous=null;
		next=null;
	}
	public DoubleLLNode getPrevious() {
		return previous;
	}
	public void setPrevious(DoubleLLNode previous) {
		this.previous = previous;
	}
	public DoubleLLNode getNext() {
		return next;
	}
	public void setNext(DoubleLLNode next) {
		this.next = next;
	}

	public User getUserMap() {
		return userMap;
	}

	public void setUserMap(User userMap) {
		this.userMap = userMap;
	}

	
}
