import java.io.*;
class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data=data;
	}
	public void displayNode() {
		System.out.print(data+" "); 
	}
}

class Tree{
	private Node root;

	Tree(){
		root=null;
	}

	public Node find(int key){
		Node current=root;
		while(current.data!=key){
			if(key<current.data)
				current=current.left;
			else
				current=current.right;
			if(current==null)
				break;
		}
		return current;
	}

	public void insert(int data){
		Node node=new Node(data);
		
		if(root==null){
			root=node;
			return;
		}

		Node current=root;
		Node parent=null;
		
		while(true){
			parent=current;
			if(data<current.data){
				current=current.left;
				if(current==null){
					parent.left=node;
					return;
				}
			}
			else{
				current=current.right;
				if(current==null){
					parent.right=node;
					return;
				}
			}
		}
	}

	public boolean delete(int key){
		Node current = root;
		Node parent = root;
		boolean isLeftChild=false;

		while(current.data!=key){
			parent=current;
			if(key<current.data){
				isLeftChild=true;
				current=current.left;
			}
			else{
				isLeftChild=false;
				current=current.right;
			}
			if(current==null)
				return false;
		}
		// found key to delete, now let's check conditions

		//if no child
		if(current.left==null && current.right==null){
			if(current==root)
				root=null;
			else if(isLeftChild)
				parent.left=null;
			else
				parent.right=null;
		}
		//if no right child, replace with left subtree
		else if(current.right==null){
			if(current==root)
				root=current.left;
			else if(isLeftChild)
				parent.left=current.left;
			else
				parent.right=current.left;
		}
		//if no left child, replace with right subtree
		else if(current.left==null){
			if(current==root)
				root=current.right;
			else if(isLeftChild)
				parent.left=current.right;
			else
				parent.right=current.right;
		}
		//if both child then replace by successor from right subtree
		else{
			Node successor=this.getSuccessor(current);
			if(current==root)
				root=successor;
			else if(isLeftChild)
				parent.left=successor;
			else
				parent.right=successor;
			successor.left=current.left;
		}

		return true;
	}

	public Node getSuccessor(Node delNode){
		Node successorParent=delNode;
		Node successor=delNode;
		Node current=delNode.right;
		while(current!=null){
			successorParent=successor;
			successor=current;
			current=current.left;	
		}
		if(successor!=delNode.right){
			successorParent.left=current.right;
			current.right=delNode.right;
		}
		return successor;
	}

	public void traverse(int traverseType){
		switch(traverseType){
			case 1: 
			System.out.print("\nPreOrder Traversal : ");
			preOrder(root);
			break;
			case 2: 
			System.out.print("\nInOrder Traversal : ");
			inOrder(root);
			break;
			case 3: 
			System.out.print("\nPostOrder Traversal : ");
			postOrder(root);
			break;
		}
		System.out.println();
	}

	public void preOrder(Node node){
		if(node==null)
			return;
		System.out.print(node.data +" ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder(Node node){
		if(node==null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+ " ");
	}
	
	public void inOrder(Node node){
		if(node==null)
			return;
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}


}


class BinarySearchTree{
	public static void main(String... args) throws IOException{

		int value;
		Tree theTree = new Tree();
		theTree.insert(50); 
		theTree.insert(25); 
		theTree.insert(75); 
		theTree.insert(12); 
		while(true) {
			System.out.print("Enter first letter of following :  ");
			System.out.print("insert, find, delete, traverse or exit: "); 
			int choice = getChar();
			switch(choice)
			{	
				case 'e':
					System.exit(0);
				case 'i':
					System.out.print("Enter value to insert: ");
					value = getInt();
					theTree.insert(value);
					break;
				case 'f':
					System.out.print("Enter value to find: "); 
					value = getInt();
					Node found = theTree.find(value);
					if(found != null){
						System.out.print("Found: "); 
						found.displayNode(); 
						System.out.print("\n");

					}
					else{
						System.out.print("Could not find ");
						System.out.print(value + "\n"); 
					}
					break;
				case 'd':
					System.out.print("Enter value to delete: "); 
					value = getInt();
					boolean didDelete = theTree.delete(value); 
					if(didDelete)
						System.out.print("Deleted " + value + "\n"); 
					else{
						System.out.print("Could not delete ");
						System.out.print(value + "\n"); 
					}
					break;
				case 't':
					System.out.print("Enter type 1 (PreOrder), 2 (InOrder) or 3 (PostOrder): "); 
					value = getInt();
					theTree.traverse(value);
					break;
				default:
					System.out.print("Invalid entry\n");
				
			}
		}
	}

	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException{
		String s = getString(); 
		return s.charAt(0);
	}

	public static int getInt() throws IOException{
		String s = getString(); 
		return Integer.parseInt(s); 
	}
	
}