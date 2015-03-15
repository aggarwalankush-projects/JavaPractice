import java.util.Scanner;

class Anagram{
	public void permutation(String str) { 
    	permutation("", str); 
	}

	private void permutation(String prefix, String str) {
    	int n = str.length();
    	if (n == 0)
    		System.out.print(prefix + "\t");
    	else
	        for(int i = 0; i < n; i++)
            	permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	}
}

class AnagramMain{

	public static void main(String... args){

		System.out.print("Enter Input String : ");
		
		Scanner scan=new Scanner(System.in);
		String str=scan.next();
		
		System.out.println("You Entered : "+str);
		System.out.println("Possible Anagrams are");
		
		Anagram anagram=new Anagram();
		anagram.permutation(str);
		
		System.out.println();

	}
}