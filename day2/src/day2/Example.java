package day2;

import java.util.Scanner;

public class Example {
	static int[] input = {7,4,2,0,0,6,0,7,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[9][];
		int i,j;
		
		
		for(i = 0; i < arr.length; i++) {
			arr[i] = new int[input[i]];
		}
		
		for(i = 0; i < arr.length; i++) {
			for(j = 0; j<arr[i].length;j++) {
				arr[i][j] = 1;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		int row = sc.nextInt();
		int column = sc.nextInt();
		System.out.println("result()");
		int result = check(arr,row,column);
		
		System.out.println("result = " + result);
	}

	static int check(int[][] arr,int row, int column) {
		System.out.println("arr[1][1] =" +arr[1][2]);
		int new_row = row -1;
		int new_column = column - 1;
		int result, cnt = 0;
//		System.out.println("new_row" + new_row);
//		System.out.println("new_column" + new_column);
		
		
		for(int i = row ; i < arr.length; i++) {
			if(arr[i][column]==1) cnt++;
		}
		
		
		
		return 	arr.length - row - cnt; 
	}
	
}
