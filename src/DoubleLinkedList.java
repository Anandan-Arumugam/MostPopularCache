
public class DoubleLinkedList {
	private DoubleLLNode head;
	private DoubleLLNode tail;
	public DoubleLinkedList(){
		head=null;
		tail=null;
	}
	public DoubleLLNode add(User user){
		if(head==null && tail==null){
			head = new DoubleLLNode(user);
			tail = head;
			return head;
		}
		else{
			if(user.getCount()>head.getUserMap().getCount()){
				addToHead(user);
				return head;
			}
			else if(user.getCount()<=tail.getUserMap().getCount()){
				DoubleLLNode thisNode = new DoubleLLNode(user);
				thisNode.setPrevious(tail);
				tail.setNext(thisNode);
				tail = tail.getNext();
				//System.out.println("here");
				return tail;
			}
			else{
				DoubleLLNode tmp = tail;
				while(tmp.getUserMap().getCount()<user.getCount()){
					tmp=tmp.getPrevious();
				}
				DoubleLLNode thisNode = new DoubleLLNode(user);
				DoubleLLNode helper = tmp.getNext();
				helper.setPrevious(thisNode);
				tmp.setNext(thisNode);
				thisNode.setPrevious(tmp);
				thisNode.setNext(helper);
				return thisNode;
			}
			
		}
	}
	
	public void printList(){
		DoubleLLNode thisNode = head;
		System.out.print("[ ");
		while(thisNode!=null){
			System.out.print(thisNode.getUserMap().getUserName()+" ");
			thisNode = thisNode.getNext();
		}
		System.out.println("]");
	}
	
	public void printList1(){
		DoubleLLNode thisNode = head;
		while(thisNode!=null){
			System.out.println(thisNode.getUserMap().getCount()+"\t"+thisNode.getUserMap().getUserName());
			thisNode = thisNode.getNext();
		}
	}
	
	public void deleteTail(){
		
		DoubleLLNode bottom = tail.getPrevious();
		tail=null;
		bottom.setNext(tail);
		tail=bottom;
	}
	
	public void addToHead(User user) {
		DoubleLLNode top = new DoubleLLNode(user);
		top.setPrevious(null);
		top.setNext(head);
		head.setPrevious(top);
		head=top;
	}
	public DoubleLLNode getTop() {
		return head;
	}
	public DoubleLLNode getBottom() {
		
		return tail;
	}
	public DoubleLLNode moveUp(DoubleLLNode user) {
		//System.out.println(head.getPrevious());
		DoubleLLNode tmp = user.getPrevious();
		while(tmp!=null && tmp.getUserMap().getCount()<=user.getUserMap().getCount()){
			tmp=tmp.getPrevious();
		}
		if(tmp==null){
			DoubleLLNode previous = user.getPrevious();
			DoubleLLNode next=user.getNext();
			if(next!=null){
				previous.setNext(next);
				next.setPrevious(previous);
			}
			else{
				previous.setNext(null);
				tail=previous;
			}
			user.setPrevious(null);
			user.setNext(head);
			head.setPrevious(user);
			head = user;
			return head;
		}
		DoubleLLNode previous = user.getPrevious();
		DoubleLLNode next=user.getNext();
		if(next!=null){
			previous.setNext(next);
			next.setPrevious(previous);
		}
		else{
			previous.setNext(null);
			tail=previous;
		}
		DoubleLLNode helper = tmp.getNext();
		tmp.setNext(user);
		user.setPrevious(tmp);
		user.setNext(helper);
		helper.setPrevious(user);
		return user;
	}
}
