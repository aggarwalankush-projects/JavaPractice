class Factorial{

	public int findFact(int num){
		if(num==1)
			return num;
		else
			return num*findFact(num-1);
	}

	public static void main(String... args){
		Factorial fact=new Factorial();
		System.out.println(fact.findFact(6));
	}
}