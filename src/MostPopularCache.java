import java.util.HashMap;


public class MostPopularCache {
	private int capacity;
	private DoubleLinkedList list;
	private int size;
	private HashMap<User,DoubleLLNode> map;
	public MostPopularCache(int value){
		list=new DoubleLinkedList();
		map = new HashMap<User,DoubleLLNode>();
		size=0;
		setCapacity(value);
	}

	public void addToCache(User user){
		if(size<=capacity){
			if(size==0){
				DoubleLLNode tmp=list.add(user);
				map.put(user,tmp);
				size++;
			}
			else if(map.containsKey(user)){
				if(map.get(user)==list.getTop()){
					map.get(user).getUserMap().setCount(user.getCount());
					return;
				}
				if(user.getCount()>map.get(user).getPrevious().getUserMap().getCount()){
					map.get(user).getUserMap().setCount(user.getCount());
					DoubleLLNode tmp=list.moveUp(map.get(user));
					map.remove(user);
					map.put(user, tmp);
				}
			}
			else if(size==capacity){
				if(user.getCount()>list.getBottom().getUserMap().getCount()){
					map.remove(list.getBottom());
					list.deleteTail();
					DoubleLLNode tmp=list.add(user);
					map.put(user, tmp);
				}
				
			}
			else{
				DoubleLLNode tmp=list.add(user);
				map.put(user, tmp);
				size++;
				
			}
			
		}
		

	}

	public DoubleLinkedList getList() {
		return list;
	}

	public void setList(DoubleLinkedList list) {
		this.list = list;
	}

	public void printCacheElements(){
		list.printList1();
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public DoubleLLNode searchData(int data){
		return null;
	}

}
