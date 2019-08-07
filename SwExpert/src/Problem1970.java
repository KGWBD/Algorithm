import java.util.Scanner;

public class Problem1970 {
	static String str;
	static int[] one = { 10, 50, 100, 500, 1000, 5000, 10000, 50000 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i = 1; i <= testCase; i++) {

			int money = sc.nextInt();

			dfs(money, one.length - 1, "");
			System.out.println("#" + i);
			System.out.println(str);
		}
	}

	static void dfs(int money, int depth, String s) {
		if (depth < 0) {
			str = s.trim();
			return;
		}

		int mok = money / one[depth];

		if (mok > 0) {
			money -= mok * one[depth];
		}
		s += mok + " ";
		dfs(money, depth - 1, s);

	}
}
