import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			String s = br.readLine();
			char cur = s.charAt(s.length() - 1);
			char next = '\u0000';
			int cnt = 0;

			for (int i = s.length() - 2; i >= 0; i--) {
				next = s.charAt(i);
				if (cur == '0' && next == '1') {
					cur = '1';
					cnt++;
				} else if (cur == '1' && next == '0') {
					cur = '0';
					cnt++;
				}
			}
			if (cur == '1')
				cnt++;
			System.out.format("#%d %d\n",t,cnt);
		} // for

	}
}
