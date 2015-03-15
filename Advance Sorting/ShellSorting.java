class ShellSorting{
	public static void main(String... args){
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i]=i*(int)(Math.random()*10);
		}
		System.out.print("Input array : ");
		for(int a:arr)
			System.out.print(a+" ");
		System.out.print("\nSorted array : ");
		new ShellSort().sort(arr);
		for(int a:arr)
			System.out.print(a+" ");
		System.out.println();
	}
}

class ShellSort{
	public void sort(int[] arr){
		int nElements=arr.length;
		int h=1;
		while(h<=nElements/3)
			h=h*3+1;
		int i, j, temp;

		while(h>0){
			for(i=h;i<nElements;i++){
				temp=arr[i];
				j=i;
				while(j > h-1 && arr[j-h]>temp){
					arr[j]=arr[j-h];
					j-=h;
				}
				arr[j]=temp;
			}
			h=(h-1)/3;
		}
	}
}