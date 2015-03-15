class BubbleSort{
	public static void main(String... args){
		int[] arr=new int[10];
		for(int i=0;i<10;i++){
			arr[i]=i*(int)(Math.random()*10);
		}
		for(int i:arr){
			System.out.print(i+" ");
		}

		new BubbleSort().sort(arr);
		System.out.println("\nAfter Sorting");
		for(int i:arr){
			System.out.print(i+" ");
		}

	}
	public void sort(int[] a){
		int len=a.length;
		int temp=0;
		for(int i=len-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
}