package day18;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc;
	static StringTokenizer st;
	static int[] h;

	public static void main(String[] args) throws NumberFormatException, IOException {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int height = sc.nextInt();
			
			h = new int[height];
			for (int i = 0; i < h.length; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			for (int i = 1; i < h.length - 1; i++) {
				int temp = h[i];
				int left = i - 1;
				int right = i + 1;
				int leftCnt = 1;
				int rightCnt = 1;
				boolean flag1 = false;
				boolean flag2 = false;
				if (temp > h[right])
					flag1 = true;
				if (h[left] < temp)
					flag2 = true;
				if (flag1 && flag2) {
					while (0 <= left - 1) {
						if (h[left - 1] < h[left]) {
							leftCnt++;
							left--;
						} else
							break;
					}
					while (right + 1 < height) {
						if (h[right] > h[right + 1]) {
							rightCnt++;
							right++;
						} else
							break;
					}
					ans += rightCnt*leftCnt;
				}
				
				
				
				
			} // for
			
			System.out.format("#%d %d\n",t , ans);

		}
	}
}
