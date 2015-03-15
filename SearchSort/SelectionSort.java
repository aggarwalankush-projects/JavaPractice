class SelectionSort{
	public static void main(String... args){
		int[] arr=new int[10];
		for(int i=0;i<10;i++){
			arr[i]=i*(int)(Math.random()*10);
		}
		for(int i:arr){
			System.out.print(i+" ");
		}

		new SelectionSort().sort(arr);
		System.out.println("\nAfter Sorting");
		for(int i:arr){
			System.out.print(i+" ");
		}

	}
	public void sort(int[] a){
		int len=a.length;
		int temp=0,min=0;
		for(int i=0;i<len-1;i++){
			min=i;
			for(int j=i+1;j<len;j++){
				if(a[min]>a[j])
					min=j;
			}

			temp=a[i];
			a[i]=a[min];
			a[min]=temp;
				
		}
	}
}