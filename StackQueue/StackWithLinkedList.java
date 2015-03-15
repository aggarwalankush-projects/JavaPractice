class Node{
	int data;
	Node next;

	Node(int data){
		this.data=data;
	}
}

class LinkedList{
	Node first;

	LinkedList(){
		first=null;
	}

	public boolean isEmpty(){
		return first==null;
	}

	public void insertFirst(int data){
		Node node=new Node(data);
		node.next=first;
		first=node;
	}

	public Node deleteFirst(){
		Node temp=first;
		first=temp.next;
		return temp;
	}

	public void displayList(){
		Node node=first;
		while(node!=null){
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}

	public Node find(int key){
		Node node=first;
		while(node!=null){
			if(node.data==key)
				return node;
			node=node.next;
		}
		return null;
	}

	public Node delete(int key){
		Node node=first;
		if(node.data==key){
			first=node.next;
			return node;
		}
		while(node!=null){
			Node temp= node.next;
			if(temp!=null  && temp.data==key){
				node.next=temp.next;
				return temp;
			}
			node=node.next;
		}
		return null;
	}
}

class LinkStack{
	private LinkedList list;

	LinkStack(){
		list=new LinkedList();
	}

	public void push(int data){
		list.insertFirst(data);
	}
	public int pop(){
		Node node=list.deleteFirst();
		return node==null?-1:node.data;
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public void displayStack(){
		list.displayList();
	}
}



class StackWithLinkedList{
	public static void main(String... args){
		LinkStack stack=new LinkStack();
		stack.push(10);
		stack.push(30);
		stack.push(20);
		stack.push(50);
		stack.displayStack();
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
}