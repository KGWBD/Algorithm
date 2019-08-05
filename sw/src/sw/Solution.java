package sw;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {

			int N = sc.nextInt();
			int K = sc.nextInt();
			int person = N * K;
			int sum =0; 
			int grade = 1;
			boolean flag = true;
			int idx = 1;
			while (person> 0) {
				
					sum+=grade;
					grade = idx*K;
					person -= K;
					
					grade += K+1;
					sum+=grade;
					person -=K;
					idx++;
				}
				
					
			
			System.out.print("#" + t);
			for(int i=0;i<K;i++) {
				System.out.print(" "+sum);
			}
			System.out.println();
		}

	}
}
