import java.util.Scanner;

class InfixToPostfix{
	private MyStack myStack;
	private StringBuilder postfix;

	public static void main(String... args){
		System.out.print("Enter Infix expression: ");
		Scanner scan=new Scanner(System.in);
		String infix=scan.next();
		// String infix="a+b-c";
		System.out.print("Postfix Notation: ");
		System.out.println(new InfixToPostfix().toPostfix(infix));
	}

	public String toPostfix(String infix){
		int length=infix.length();
		postfix=new StringBuilder();
		myStack=new MyStack(length);
		for(int i=0;i<length;i++){
			char c=infix.charAt(i);
			switch(c){
				case '+':
				case '-':
					processOP(c,1);
					break;
				case '/':
				case '*':
					processOP(c,2);
					break;
				case '(':
					myStack.push(c);
					break;
				case ')':
					gotParent();
					break;
				default:
					postfix.append(c+"");	
			}
		}
		while(!myStack.isEmpty())
			postfix.append(myStack.pop()+"");
		return postfix.toString();

	}

	public void processOP(char op, int priority1){
		if(myStack.isEmpty()){
			myStack.push(op);
		}
		else{
			char stackTop=myStack.peek();
			int priority2=0;
			if(stackTop=='('){
				myStack.push(op);
				return;
			}
			else if(stackTop=='/' || stackTop=='*'){
				priority2=2;
			}
			else if(stackTop=='+' || stackTop=='-'){
				priority2=1;
			}

			if(priority1>priority2){
				myStack.push(op);
			}
			else{
				postfix.append(myStack.pop()+"");
				myStack.push(op);
			}

		}
	}
	public void gotParent(){
		while(!myStack.isEmpty()){
			char c=myStack.pop();
			if(c=='(')break;
			postfix.append(c+"");
		}
	}
}

class MyStack{
	private int top;
	private char[] stackArray;
	private int size;

	MyStack(int size){
		this.size=size;
		stackArray=new char[size];
		top=-1;
	}

	public void push(char c){
		stackArray[++top]=c;
	}
	public char pop(){
		return stackArray[top--];
	}
	public boolean isEmpty(){
		return top==-1;
	}
	public char peek(){
		return stackArray[top];
	}

}