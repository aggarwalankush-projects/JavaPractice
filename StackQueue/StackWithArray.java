class MyStack{
	private int size;
	private int[] stackArray;
	private int top;

	MyStack(int size){
		this.size=size;
		stackArray=new int[size];
		top=-1;
	}

	public void push(int element){
		if(top+1<size)
		stackArray[++top]=element;
		else
			System.out.println("Stack is full");
	}
	public int pop(){
		return stackArray[top--];
	}
	public int peek(){
		return stackArray[top];
	}

	public boolean isEmpty(){
		return (top==-1);
	}

}

class StackWithArray{
	public static void main(String... args){
		MyStack myStack=new MyStack(1);
		System.out.println(myStack.isEmpty());
		myStack.push(10);
		myStack.push(3);
		System.out.println(myStack.isEmpty());
		while(!myStack.isEmpty()){
			System.out.println(myStack.pop());
		}
		System.out.println(myStack.isEmpty());
	}
}