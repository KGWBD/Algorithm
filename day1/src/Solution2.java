import java.awt.print.Printable;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6];
		int triplet = 0;
		int straight = 0;
		for(int i =0; i<6;i++) {
			arr[i] = sc.nextInt();
			
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length - 1 ; i++) {
			if(arr[i] == arr[i+1]) {
				triplet += 1;
			} else if((arr[i+1]-arr[i])==1) {
				straight += 1;
			}
		
		}
		if(triplet==2 && straight==2) {
			System.out.println("Baby-gin");
		} else if(triplet==4) {
			System.out.println("Baby-gin");
		} else if(straight==4) {
			System.out.println("Baby-gin");
			
		}
		
		
	}
	
	
}
