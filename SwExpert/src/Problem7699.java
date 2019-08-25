import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem7699 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int cnt;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			st = new StringTokenizer(br.readLine()); // 2 4
			int R = Integer.parseInt(st.nextToken()); // 2
			int C = Integer.parseInt(st.nextToken()); // 4

			String[][] lands = new String[R][C];
			
			for (int y = 0; y < R; y++) {
				String[] str = br.readLine().split("");

				for (int x = 0; x < C; x++) {
					lands[y][x] = str[x];
				}
			} // lands 배열 생성
			
			cnt = 0;
			dfs(lands, 0, 0, "");
			System.out.format("#%d %d\n",t,cnt);

		} // testCase

	}

	private static void dfs(String[][] lands, int y, int x,String s) {
		s += lands[y][x];
		int tx, ty;
		for (int i = 0; i < 4; i++) {
			ty = y + dy[i];
			tx = x + dx[i];

			if (ty < 0 || ty == lands.length || tx < 0 || tx == lands[0].length) {
				continue;
			}

			if (!s.contains(lands[ty][tx])) {
				dfs(lands, ty, tx,s);
			}

		}
		if(cnt<s.length()) {
			cnt = s.length();
		}

	}
}
