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


class LinkListMain{
	public static void main(String... args){
		LinkedList list=new LinkedList();
		list.insertFirst(10);
		list.insertFirst(20);
		list.insertFirst(30);
		list.insertFirst(40);
		list.displayList();
		System.out.println(list.find(20).data);
		System.out.println(list.find(200)==null);
		System.out.println(list.delete(20).data);
		// System.out.println(list.delete(30).data);
		// System.out.println(list.delete(10).data);
		// System.out.println(list.delete(40).data);
		while(!list.isEmpty()){
			System.out.println(list.deleteFirst().data);
		}
		list.displayList();
	}
}