import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2573 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static int N, M;
	static int ans;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int island = 0;
		boolean flag;
		for (int y = 1; y <= 5000; y++) {
			island = 0;
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && map[i][j] == 0) {
						searchOuterIsland(i, j);
					}
				}
			} // ¿Ü°ûÁö¿ª ¼¶ ±¸ÇÏ±â.

			melting();
//				for(int i = 0 ; i < N ; i++) {
//					System.out.println(Arrays.toString(map[i]));
//				}
//				System.out.println("=================");
			visited = new boolean[N][M];
			flag = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && map[i][j] > 0) {
						solve(i, j);
						island++;
						flag = true;
					}
				}
			} // ¼¶ÀÌ ¸îµ¢ÀÌÀÎÁö ÆÇ´Ü.
			if (!flag)
				break;
			if (island > 1) {
				ans = y;
				break;
			}
		}

		System.out.println(ans);

	}

	private static void searchOuterIsland(int y, int x) {
		Queue<Position> q = new LinkedList<Boj2573.Position>();
		visited[y][x] = true;
		q.offer(new Position(y, x));
		int ny, nx;
		Position pos;
		while (!q.isEmpty()) {
			pos = q.poll();

			for (int i = 0; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];

				if (!isRange(ny, nx))
					continue;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					if (map[ny][nx] == 0) {
						q.offer(new Position(ny, nx));
					}
				}
			}
		}
	}

	private static void melting() {
		int ny, nx, cnt;
		int[][] tempArr = new int[N][M];
		ny = 0;
		nx = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				cnt = 0;

				if (map[y][x] > 0) {
					if (visited[y][x]) {
						for (int i = 0; i < 4; i++) {
							ny = y + dy[i];
							nx = x + dx[i];

							if (!isRange(ny, nx))
								continue;

							if (map[ny][nx] == 0)
								cnt++;
						} // for
						if (map[y][x] - cnt > 0)
							tempArr[y][x] = map[y][x] - cnt;
					} else {
						tempArr[y][x] = map[y][x];
					}
				}
			}
		}
		map = tempArr;
	}

	private static void solve(int y, int x) {
		Queue<Position> q = new LinkedList<Boj2573.Position>();
		visited[y][x] = true;
		q.offer(new Position(y, x));
		int ny, nx;
		Position pos;
		while (!q.isEmpty()) {
			pos = q.poll();

			for (int i = 0; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];

				if (!isRange(ny, nx))
					continue;

				if (!visited[ny][nx] && map[ny][nx] > 0) {
					visited[ny][nx] = true;
					q.offer(new Position(ny, nx));
				}
			}
		}
	}

	static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == M)
			return false;
		return true;
	}

	static class Position {
		int y, x;

		Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
