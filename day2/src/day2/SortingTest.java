package day2;

import java.util.Arrays;

public class SortingTest {
	static int[] arr = {3,5,8,4,7,1,3,3};
	
	static void print(int[] arr) {
//		for(int i:arr) {
//			System.out.print(i + " ");
//		}
		
		System.out.println(Arrays.toString(arr));
	}
	static void bubbleSort() {
		int tmp;
		
		
		for(int i = arr.length-1; i > 0 ; i--) {
			for(int j = 0; j < i ;j++) {
				if(arr[j] > arr[j+1]) {
					
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					
				}
			}
		}
		
		
		print(arr);
	}
	
	
	static void selectionSort() {
		int tmp, min;
		
		for(int i = 0; i < arr.length -1;i++) {
			min = i;
			for(int j = i+1; j < arr.length;j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
				
			}
			tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
			
		}
		print(arr);
		
	}
	
//	static void insertionSort() {
//		int tmp, index;
//		
//		for(int i = 1; i < arr.length; i++) {
//			tmp = arr[i];
//			index = i;
//			for(int j; j < i;j++) {
//				if(arr[j]>tmp) {
//					
//				}
//			}
//		}
//	}
	
	public static void main(String[] args) {
		selectionSort();
		
		
	}
}
