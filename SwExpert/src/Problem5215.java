import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5215 {
	static int score,cal;
	static int ans;
	static int L;
	static int[] cals;
	static int[] scores;
	static boolean[] visited;
	static String[] str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			L = Integer.parseInt(str[1]);
			visited = new boolean[N];
			cals = new int[N];
			scores = new int[N];
			
			for (int i = 0; i < N; i++) {
				str = br.readLine().split(" ");
				scores[i] = Integer.parseInt(str[0]);
				cals[i] = Integer.parseInt(str[1]);
			}
			ans =0;
			powerSet(0);
			System.out.format("#%d %d\n", t, ans);

		} // for tc
	}

	private static void powerSet(int depth) {
		if (depth == cals.length) {
			score = 0;
			cal = 0;
			for (int i = 0; i < cals.length; i++) {
				if (visited[i]) {
					cal += cals[i];
					score += scores[i];
				}
			}

			if (cal >= L) {
				return;
			}

			if (ans < score) {
				ans = score;
			}
			
			return;

		}

		visited[depth] = true;
		powerSet(depth + 1);
		visited[depth] = false;
		powerSet(depth + 1);

	}

}
