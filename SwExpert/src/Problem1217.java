import java.util.Scanner;

public class Problem1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		for (int t = 1; t <= 10; t++) {
			int base = sc.nextInt();
			int exp = sc.nextInt();
			int result = doPow(base, exp);
			System.out.format("#%d %d", t, result);
		}
	}

	static int doPow(int base, int exp) {
		if (exp == 0)
			return 1;
		else if (exp == 1)
			return base;

		int num = doPow(base, exp / 2);
		int result = num * num;
		if (exp % 2 != 0) {
			result *= base;
		}

		return result;
	}
}
