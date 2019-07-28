import java.util.Scanner;

public class Problem1986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i = 1; i <= testCase; i++) {

			int N = sc.nextInt();
			int result = sumAndMinus(N);

			System.out.println(String.format("#%d %d", i, result));
		}
	}

	public static int sumAndMinus(int n) {
		if (n <= 0) {
			return 0;
		} else {
			if (n % 2 == 0) {
				return -n + sumAndMinus(n - 1);

			} else {
				return +n + sumAndMinus(n - 1);
			}

		}

	}
}
