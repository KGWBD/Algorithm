import java.util.Scanner;

public class Problem2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = -1;

			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					for (int k = 0; k < M; k++) {
						for (int p = 0; p < M; p++) {
							sum += arr[i + k][j + p];
						}
					}

					if (max < sum) {
						max = sum;
					}
				}
			}
			System.out.println(String.format("#%d %d", t,max));

		}
	}
}
