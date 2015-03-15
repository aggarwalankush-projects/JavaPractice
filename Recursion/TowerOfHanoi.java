class TowerOfHanoi{
	private static int disks=3;

	public static void main(String... args){
		doTowers(disks,'A','B','C');
	}

	public static void doTowers(int disks, char source, char aux, char dest){
		if(disks==1)
			System.out.println(source+" --> "+dest);
		else{
			doTowers(disks-1, source, dest, aux);
			System.out.println(source+" --> "+dest);
			doTowers(disks-1, aux, source, dest);
		}
	}

}