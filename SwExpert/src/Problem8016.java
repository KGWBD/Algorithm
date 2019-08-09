
import java.util.Scanner;

public class Problem8016 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {

			long n = sc.nextInt();

			long mid = 2 * n * n - 2 * n + 1;
			long N, K;
			if (n == 1) {
				K = N = 1;
			} else {
				N = mid - 2 * (n - 1);
				K = mid + 2 * (n - 1);
			}

			System.out.format("#%d %d %d",t,N,K);

		}

	}
}

//
//
//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	int testCase = sc.nextInt();
//	for (int t = 1; t <= testCase; t++) {
//
//		int n = sc.nextInt();
//		long[] arr = new long[n * n + 1];
//
//		for (int i = 1; i < arr.length; i++) {
//			arr[i] = 2 * (i - 1) + 1;
//		}
//		
//		int idx = 0;
//		long N, K;
//		for (int i = 1; i < n; i++) {
//			idx += arr[i];
//		}
//		idx += 1;
//		N = arr[idx];
//		K = arr[n * n];
//
//		System.out.format("#%d %d %d",t , N, K);
//	}
//
//}