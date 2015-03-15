class Node{
	int data;
	Node next;
	Node previous;
	Node(int data){
		this.data=data;
	}
}

class LinkedList{
	private Node first;
	private Node last;

	LinkedList(){
		first=null;
		last=null;
	}

	public boolean isEmpty(){
		return first==null;

	}
	
	public void insertFirst(int data){
		Node node=new Node(data);
		if(this.isEmpty())
			last=node;
		else
			first.previous=node;
		node.next=first;
		first=node;
	}

	public void insertLast(int data){
		Node node=new Node(data);
		if(this.isEmpty())
			first=node;
		else{
			node.previous=last;
			last.next=node;
		}
		last=node;
	}

	public int deleteFirst(){
		Node node=first;
		if(this.isEmpty())
			return -1;
		if(first.next==null)
			last=null;
		else
			first.previous=null;		
		first=first.next;
		
		return node.data;
	}

	public int deleteLast(){
		Node node=last;
		if(this.isEmpty())
			return -1;
		if(last.previous==null)
			first=null;
		else
			last.previous.next=null;
		last=last.previous;
		
		return node.data;
	}

	public boolean insertAfter(int key, int data){
		Node current=first;
		while(current!=null && current.data!=key){
			current=current.next;
			if(current==null)
				return false;
		}
		Node node=new Node(data);

		node.next=current.next;
		node.previous=current;

		if(current.next==null)
			last=node;
		else
			current.next.previous=node;
		
		current.next=node;
		
		return true;

	}

	public boolean deleteKey(int key){
		Node current = first;
		while(current!=null && current.data!=key){
			current=current.next;
			if(current==null)
				return false;
		}

		if(current==first)
			first=current.next;
		else
			current.previous.next=current.next;
		
		if(current==last)
			last=current.previous;
		else
			current.next.previous=current.previous;

		return true;
	}

	public void displayForward(){
		Node node=first;
		while(node!=null){
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	
	public void displayBackward(){
		Node node=last;
		while(node!=null){
			System.out.print(node.data+" ");
			node=node.previous;
		}
		System.out.println();
	}
}

class DoublyLinkedList{
	public static void main(String... args){
		LinkedList theList = new LinkedList();
		theList.insertFirst(22);
		theList.insertFirst(44); 
		theList.insertFirst(66);
		theList.insertLast(11); 
		theList.insertLast(33); 
		theList.insertLast(55);
		theList.displayForward(); 
		theList.displayBackward();
		theList.deleteFirst(); 
		theList.deleteLast(); 
		theList.deleteKey(11);
		theList.displayForward();
		theList.insertAfter(22, 77); 
		theList.insertAfter(33, 88);
		theList.displayForward();

	}
}