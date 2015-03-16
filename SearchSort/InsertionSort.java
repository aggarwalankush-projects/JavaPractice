class InsertionSort{
	public static void main(String... args){
		int[] arr=new int[10];
		for(int i=0;i<10;i++){
			arr[i]=i*(int)(Math.random()*10);
		}
		for(int i:arr){
			System.out.print(i+" ");
		}

		new InsertionSort().sort(arr);
		System.out.println("\nAfter Sorting");
		for(int i:arr){
			System.out.print(i+" ");
		}

	}
	public void sort(int[] a){
		int len=a.length;
		int temp=0,j=0;
		for(int i=1;i<=len-1;i++){
			j=i;
			int element=a[i];
			while(j>0 && element<=a[j-1]){
				a[j]=a[j-1];
				j--;
			}
			a[j]=element;
		}
	}
}
