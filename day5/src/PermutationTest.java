

import java.util.Arrays;

public class PermutationTest {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		doPerm(arr,0);
		
		
	}

	private static void doPerm(int[] arr, int loc) {
//		종료, 실행, 자기호출
		if(loc==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i = loc; i < arr.length;i++) {
			swap(arr,i,loc);
			doPerm(arr,loc+1);
			swap(arr,i,loc);
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	
	
	

}
