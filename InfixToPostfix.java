class InfixToPostfix{
	public static void main(String... args){
		System.out.println("Enter Infix expression: ");
		Scanner scan=new Scanner(System.in);
		String infix=scan.next();

		System.out.println(new InfixToPostfix().toPostfix(infix));
	}
	public String toPostfix(String infix){
		int length=infix.length();
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
		
	}
}