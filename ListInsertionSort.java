class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
	}
}

class SortedList{
	Node first;

	SortedList(){
		first=null;
	}

	public boolean isEmpty(){
		return first==null;

	}
	public void insert(int data){
		Node node=new Node(data);
		Node previous=null;
		Node current=first;
		while(current!=null && data>current.data){
			previous=current;
			current=current.next;
		}
		if(previous==null)
			first=node;
		else{
			previous.next=node;
		}
		node.next=current;
	}

	public int remove(){
		Node node=first;
		if(this.isEmpty())
			return -1;
		first=first.next;
		return node.data;
	}

	public void displayList(){
		Node node=first;
		while(node!=null){
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
}

class SortedListMain{
	public static void main(String... args){
		SortedList theSortedList = new SortedList();
		theSortedList.insert(20); 
		theSortedList.insert(40);
		theSortedList.displayList();
		theSortedList.insert(10); 
		theSortedList.insert(30); 
		theSortedList.insert(50);
		theSortedList.displayList(); 
		theSortedList.remove();
		theSortedList.displayList();

	}
}