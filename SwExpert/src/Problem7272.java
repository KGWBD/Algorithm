import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem7272 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] compStrs = new String[3];
		compStrs[0] = "CEFGHIJKLMNSTUVWXYZ";
		compStrs[1] = "ADOPQR";
		compStrs[2] = "B";
		String result;
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {

			st = new StringTokenizer(br.readLine(), " ");

			String str1 = st.nextToken();
			String str2 = st.nextToken();
			int cnt = 0;
			
			if (str1.length() != str2.length()) {
				result = "DIFF";
				System.out.println(String.format("#%d %s", t, result));
				continue;
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < str1.length(); j++) {
					boolean check1 = compStrs[i].contains(String.valueOf(str1.charAt(j)));
					boolean check2 = compStrs[i].contains(String.valueOf(str2.charAt(j)));
//				System.out.printf("%b : %b\n",check1,check2);
					if (check1 && check2)
						cnt++;
				}
			}
			
			result = cnt == str1.length() ? "SAME" : "DIFF";

			System.out.println(String.format("#%d %s", t, result));

		}

	}
}
