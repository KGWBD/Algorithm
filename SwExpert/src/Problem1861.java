import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1861 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int max;
	static int minVal;
	static int temp;
	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
//		int T = 1;

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = Integer.MIN_VALUE;
			minVal = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1, map[i][j]);
				}
			}
			
			System.out.format("#%d %d %d\n", t, minVal, max);
		} // testCase

	}
	
	private static void dfs(int y, int x, int cnt, int temp) {
		if (max < cnt) {
			max = cnt;
			minVal = temp;
		} else if (max == cnt) {
			if (minVal > temp)
				minVal = temp;
		}

		int ty, tx;
		int cur = map[y][x];
		for (int i = 0; i < 4; i++) {
			ty = y + dy[i];
			tx = x + dx[i];

			if (tx < 0 || tx == N || ty < 0 || ty == N) {
				continue;
			}

			if (map[ty][tx] - 1 == cur) {
				dfs(ty, tx, cnt + 1, temp);
			}

		}

	}

}
