

public class PowerSet {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		flags = new boolean[arr.length];
		doPowerSet(arr,0,arr.length);
	}
	static boolean[] flags = null;
	static void doPowerSet(int[] arr, int depth, int max) {
		if(depth ==max	) {
//			작업 수행, 출력
			printArr(arr);
			return;
		}
		flags[depth] = true;
		doPowerSet(arr, depth+1,max);
		flags[depth] = false;
		doPowerSet(arr, depth+1,max);
	}
	static void printArr(int[] arr) {
		for(int i =0; i < arr.length; i++) {
			if(flags[i]) {
				System.out.print(arr[i]+ " ");
			}
		}
		System.out.println();
	
	}
}
