import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1240 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] defaultCode = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };
		
		String[] codes = null;
		int[] ans = null;
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {

			codes = new String[8];
			ans = new int[8];
			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String str = "";
			String code = "";
			for (int i = 0; i < N; i++) {
				str = br.readLine();

				if (str.lastIndexOf("1") == -1) {
					continue;
				} else {
					code = str;
				}
			}
			
			int idx = code.lastIndexOf("1");
			code = code.substring(idx - 55, idx + 1);

			for (int i = 0; i < 8; i++) {
				codes[i] = code.substring(i * 7, (i + 1) * 7);
			}
			
			for (int i = 0; i <= 7; i++) {
				for (int j = 0; j <= 9; j++) {
					if (codes[i].equals(defaultCode[j])) {
						ans[i] = j;
						break;
					}
				}
			}
			
			
			int sum = (ans[0] + ans[2] + ans[4] + ans[6]) * 3 + ans[1] + ans[3] + ans[5] +ans[7];
			int result = 0;
			System.out.format("#%d ", t);
			
			if ((sum)%10==0) {
				for (int n : ans) {
					result += n;
				}
				System.out.println(result);

			} else {
				System.out.println(0);
			}
		}
	}
}
