import java.util.Arrays;
class Search{

	public int binarySearch(int key, int[] arr, int low, int high){
		int mid=(low+high)/2;
		if(arr[mid]==key)
			return mid;
		else if (low>high)
			return -1;
		else if(arr[mid]<key)
			return binarySearch(key, arr, mid+1, high);
		else
			return binarySearch(key, arr, low, mid-1);
	}

	public int binarySearch(int[] arr, int key){
		return binarySearch(key, arr, 0, arr.length-1);
	}
}


class BinarySearch{

	public static void main(String... args){
		Search search=new Search();
		int[] arr= new int[10];
		for(int i=0;i<10;i++){
			arr[i]=i*(int)(Math.random()*10);
		}
		Arrays.sort(arr);
		System.out.print("Input array : ");
		for(int element:arr)
			System.out.print(element+" ");
		int key=5;
		System.out.println("\nSearch Key : "+ key);
		int index=search.binarySearch(arr,key);
		if(index!=-1)
			System.out.println("Key found at index : " + index);
		else 
			System.out.println("key not found");	
	}
}