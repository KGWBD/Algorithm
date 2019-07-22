package day2;

import java.util.Arrays;

public class CountingSort {

	static int[] arr = {1,3,2,4,1,2,3,1,4,4,4,2,1,3,2,1,3,1,0};
	// 혼자 해본 countingSort
	static int[] myCountingSort() {
		int[] brr = new int[5];
		int[] result = new int[arr.length];
		
		for(int i = 0 ; i < arr.length; i++) {
			brr[arr[i]] += 1;                           //brr[arr[i]]++;
		}
		
		for(int j = 0 ; j < brr.length-1; j++) {
			brr[j+1] = brr[j] + brr[j+1];				//brr[j+1] += brr[j] 복합대입연산자가빠름
		}
		
		System.out.println(Arrays.toString(brr));
		
		for(int i = 0; i < arr.length; i++) {
			brr[arr[i]] -= 1;
			result[brr[arr[i]]] = arr[i];
			
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,2,1,1,2,1,0};
		final int K = 4;
		int[] counting = new int[K+1];
		int[] brr = new int[arr.length+1];
		countingSort(arr, brr, counting, K);		
		
		for(int i =0; i < brr.length; i++) {
			System.out.print(i + " ");
		}
		
	}
	//강사님 함수
	static void countingSort(int[] arr, int[] brr, int[] counting, int K) {
		for(int i = 0; i < arr.length; i++) {
			int idx = arr[i];
			counting[idx]++;
		}
		for(int j = 0; j < counting.length-1; j++) {
			counting[j+1] += counting[j]; 
		}
		for(int i = 0; i < arr.length; i++) {
			int idx = arr[i];
			int idx1 = counting[idx];
			brr[idx1] = arr[i];
			counting[idx]--;
		}
	}
}
