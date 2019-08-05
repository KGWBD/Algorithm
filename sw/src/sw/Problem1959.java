package sw;

import java.util.Scanner;

public class Problem1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 1; t <= testCase; t++) {

			int n = sc.nextInt();
			int m = sc.nextInt();
			
			
			int[] nArr = new int[n];
			int[] mArr = new int[m];

			for (int i = 0; i < n; i++) {
				nArr[i] = sc.nextInt();
			}

			for (int i = 0; i < m; i++) {
				mArr[i] = sc.nextInt();
			}
			
			int idx = 0;
			int max = -1;
			int temp;
			int[] temps;
			if(n>m) {
				temp = n ;
				n = m;
				m = temp;
				temps = nArr;
				nArr = mArr;
				mArr = temps;
			}
			while ((n + idx) <= m) {
				int sum = 0;
				for (int i = idx; i < n + idx; i++) {
					sum += nArr[i - idx] * mArr[i];
				}
				if (max < sum) {
					max = sum;
				}
				idx++;
			}
			System.out.format("#%d %d\n",t,max);

		}

	}
	
	
}
