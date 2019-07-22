package day2;

import java.util.Arrays;

public class LotationTest {

	public static void main(String[] args) {
//		int[] arr = {1,2,3,4,5,6,7,8,9,10};
//		lotate(arr);
//		System.out.println(Arrays.toString(arr));
		
		int[][] arr = new int[4][4];
		int[][] brr = new int[4][4];
		int[][] crr = new int[4][4];
		int[][] drr = new int[4][4];
		int cnt = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				arr[i][j] = cnt++;
			}
		}
		
//		90도 회전하기
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				brr[j][3-i] = arr[i][j];
			}
		}
//		180도 회전하기		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				crr[3-i][j] = arr[i][j];
			}
		}
//		270도 회전하기
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				crr[3-j][i] = arr[i][j];
			}
		}
		
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
//				System.out.print(arr[i][j] + "\t");
//				System.out.print(brr[i][j] + "\t");
				System.out.print(crr[i][j] + "\t");
				
			}
			System.out.println();
		}
		
	}
	
	static void lotate(int[] arr) {
		int temp = 0;
		temp = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];	
		}
		arr[arr.length-1] = temp;
		
		
	}
}
