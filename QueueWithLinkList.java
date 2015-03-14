class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
	}
}

class LinkedList{
	Node first;
	Node last;

	LinkedList(){
		first=null;
		last=null;
	}

	public boolean isEmpty(){
		return first==null;
	}

	public void insertLast(int data){
		Node node=new Node(data);
		node.next=null;
		if(this.isEmpty())
			first=node;
		else
			last.next=node;
		last=node;
	}

	public int deleteFirst(){
		if(this.isEmpty())
			return -1;
		Node node=first;
		if((first=first.next)==null)
			last=null;
		return node.data;
	}

	public void displayList(){
		Node first=this.first;
		while(first!=null){
			System.out.print(first.data+" ");
			first=first.next;
		}
		System.out.println();
	}

}

class Queue{
	
	LinkedList list;
	
	Queue(){
		list=new LinkedList();
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void enqueue(int data){
		list.insertLast(data);
	}
	
	public int dequeue(){
		return list.deleteFirst();
	}

	public void display(){
		list.displayList();
	}

}



class QueueWithLinkList{
	public static void main(String... args){
		Queue theQueue=new Queue();
		theQueue.enqueue(20); 
		theQueue.enqueue(40);
		theQueue.display();
		theQueue.enqueue(60); 
		theQueue.enqueue(80);
		theQueue.enqueue(90);
		theQueue.display();
		theQueue.dequeue(); 
		theQueue.dequeue();
		theQueue.dequeue();
		theQueue.display();
	}
}