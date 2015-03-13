class BinarySearch{
	public static void main(String... args){
		int[] arr=new int[10];
		for(int i=0;i<10;i++){
			arr[i]=i*20;
		}
		System.out.println(new BinarySearch().find(20, arr, 0, arr.length-1));
	}
	public int find(int toSearch,int[] arr, int low, int high){
		int mid=0;
		while(low<=high){
			mid=(low+high)/2;
			if(toSearch==arr[mid])
				return mid;
			else if(toSearch<arr[mid]){
				high=mid-1;
			}
			else
				low=mid+1;
		}
		return -1;

	}
}