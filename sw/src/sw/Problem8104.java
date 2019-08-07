package sw;

import java.util.Scanner;

public class Problem8104 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {

			int N = sc.nextInt();
			int K = sc.nextInt();
			int person = N * K;
			int[] sum;
			int grade = 1;
			boolean flag = true;
			int idx = 0;
			sum = new int[K];
			while (person> 0) {
				while(idx<K && person>0) {
					sum[idx++] += grade++;
					person--;
				} 
				while(idx>0 && person >0) {
					sum[--idx] += grade++;
					person--;
				}
			}
			
			System.out.print("#" + t);
			for(int i=0;i<K;i++) {
				System.out.print(" "+sum[i]);
			}
			System.out.println();
		}

	}
}
