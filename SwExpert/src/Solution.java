import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int[][] dp;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		int T = Integer.parseInt(br.readLine());
		int T = 1;

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dp[i], -1);
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 0);
				}
			}
			int maxY = 0;
			int maxX = 0;
			int max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max < dp[i][j]) {
						max = dp[i][j];
						maxY = i;
						maxX = j;
					}
				}
			}
			bw.write("#" + t + " ");
			bw.write(maxY + " " + maxX + " \n");
		}
		bw.close();
	}

	private static int dfs(int y, int x, int cnt) {

		int ny, nx;
		int temp = 0;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];

			if (!isRange(ny, nx))
				continue;

			if (map[y][x] + 1 == map[ny][nx]) {
				dfs(y, x, cnt + 1);
			}
		}

		return cnt;

	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == N)
			return false;
		return true;
	}
}
