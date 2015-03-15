class MergeSortMain{
	public static void main(String... args){
		int[] arr=new int[10];
		for(int i=0;i<10;i++){
			arr[i]=i*(int)(Math.random()*10);
		}
		System.out.print("Input Array : ");
		for(int a:arr)
			System.out.print(a+" ");
		new MergeSort().mergeSort(arr, 0, arr.length-1);
		System.out.print("\nSorted Array : ");
		for(int a:arr)
			System.out.print(a+" ");
		System.out.println();
	}
}

class MergeSort{

	public void mergeSort(int[] arr, int low, int high){
		if(low<high){
			int mid=(low+high)/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1, high);
			merge(arr, low, mid, high);
		}
	}

	public void merge(int[] arr, int low, int mid, int high){

		int n1=mid-low+1;
		int n2=high-mid;
		
		int[] left=new int[n1+1];
		int[] right=new int[n2+1];

		for(int i=0;i<n1;i++)
			left[i]=arr[low+i];
		left[n1]=Integer.MAX_VALUE;
		
		for(int i=0;i<n2;i++)
			right[i]=arr[mid+1+i];
		right[n2]=Integer.MAX_VALUE;
		
		int i=0,j=0;

		for(int k=low;k<=high;k++){
			if(left[i]<=right[j])
				arr[k]=left[i++];
			else
				arr[k]=right[j++];
		}


	}
}