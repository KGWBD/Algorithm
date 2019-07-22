package day2;



import java.io.IOException;
import java.util.Scanner;

public class HomeWork2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] counts;
		
		
		for(int i = 0; i < testCase; i++) {
			int fistNum = sc.nextInt();
			int secondNum = sc.nextInt();
			counts = new int[fistNum];
			for(int j = 0; j < fistNum;j++) {
				counts[j] = j+1;
			}
			
//			System.out.println(Arrays.toString(counts));
			
			for(int k =0; k<secondNum;k++) {
				int removeIndex = sc.nextInt();
				counts[removeIndex-1] = 0;
			}
			
			System.out.printf("#%d",(i+1));
			for(int j:counts) {
				if(j != 0)System.out.print(" " + j);
			}
			System.out.println();
			
			
		}
		
		
		
		
	}
}
