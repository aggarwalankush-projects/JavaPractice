class MyQueue{
	private int size;
	private int[] queueArray;
	private int first;
	private int last;
	private int items;

	MyQueue(int size){
		this.size=size;
		queueArray=new int[size];
		first=0;
		last=-1;
		items=0;
	}

	public void insert(int element){
		if(this.isFull())return;
		if(last==size-1)
			last=-1;
		queueArray[++last]=element;
		items++;
	}
	public int remove(){
		if(this.isEmpty())return -1;
		int element=queueArray[first++];
		if(first==size)
			first=0;
		items--;
		return element;
	}
	public int peek(){

		return queueArray[first];
	}

	public boolean isEmpty(){

		return (items==0);
	}

	public boolean isFull(){
		return (items==size);
	}
	public int size(){
		return items;
	}
}

class QueueWithArray{
	public static void main(String... args){
		MyQueue myQueue=new MyQueue(5);
		System.out.println(myQueue.isEmpty());
		myQueue.insert(10);
		myQueue.insert(20);
		myQueue.insert(30);
		myQueue.insert(40);
		myQueue.remove();
		myQueue.insert(50);
		myQueue.insert(60);
		System.out.println(myQueue.size());
		while(!myQueue.isEmpty()){
			System.out.println(myQueue.remove());
		}
		System.out.println(myQueue.isEmpty());
	}
}