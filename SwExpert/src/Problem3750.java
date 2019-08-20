import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3750 {
	static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {

			String str = br.readLine();
			ans = 0L;
			fun(str);

			System.out.format("#%d %d\n", i, ans);
		}
	}

	private static void fun(String str) {
		if (str.length() == 1) {
			ans = Integer.parseInt(str);
			return;
		}

		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}

		fun(String.valueOf(sum));

	}

}
