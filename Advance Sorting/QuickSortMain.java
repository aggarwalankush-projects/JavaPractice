class QuickSortMain{
	public static void main(String... args){
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i]=i*(int)(Math.random()*10);
		}
		System.out.print("Input array : ");
		for(int a:arr)
			System.out.print(a+" ");
		System.out.print("\nSorted array : ");
		new QuickSort().sort(arr);
		for(int a:arr)
			System.out.print(a+" ");
		System.out.println();
	}
}

class QuickSort{
	public void sort(int[] arr){
		quickSort(arr,0, arr.length-1);
	}

	public void quickSort(int[] arr, int p, int r){
		if(p<r){
			int q=partition(arr,p, r);
			quickSort(arr,p,q-1);
			quickSort(arr,q+1,r);
		}
	}

	public int partition(int[] arr, int p, int r){
		int i=p-1;
		int pivot=arr[r];
		for(int j=p;j<r;j++)
			if(arr[j]<=pivot)
				swap(arr,++i,j);
		swap(arr,i+1,r);
		return i+1;
	}
	public void swap(int[] arr, int a, int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

}