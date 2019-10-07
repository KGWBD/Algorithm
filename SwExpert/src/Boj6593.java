import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj6593 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][][] map;
	static boolean[][][] visited;
	static int[][] directions = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 1, 0, 0 }, { -1, 0, 0 } };
	static int R, C, H;
	static Position start;
	static int ans;

	public static void main(String[] args) throws IOException {

		while (true) {

			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(H==0 && R==0 && C==0)break;
			map = new char[H][R][C];
			visited = new boolean[H][R][C];

			for (int h = 0; h < H; h++) {
				for (int r = 0; r < R; r++) {
					map[h][r] = br.readLine().toCharArray();
				}
				br.readLine();
			}
			int cnt = 0;
			boolean flag = false;
			for (int h = 0; h < H; h++) {
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						if (map[h][r][c] == 'S') {
							start = new Position(h, r, c, 0);
						} else if (map[h][r][c] == 'E') {
							int nh, ny, nx;
							for (int i = 0; i < 6; i++) {
								nh = h + directions[i][0];
								ny = r + directions[i][1];
								nx = c + directions[i][2];
								if (!isRange(nh, ny, nx)) {
									cnt++;
									continue;
								}
								if (map[nh][ny][nx] == '#')
									cnt++;
							}
							if (cnt == 6) {
								flag = true;
							}
						}
					}
				}
			} // start, end 지점 찾는 for문
			ans = 0;
			if (!flag)
				bfs();
			if (ans != 0) {
				System.out.println("Escaped in " + ans + " minute(s).");
			} else {
				System.out.println("Trapped!");
			}
		}
	}

	private static void bfs() {
		Queue<Position> q = new LinkedList<Position>();
		q.offer(start);
		visited[start.h][start.y][start.x] = true;
		int nh, ny, nx;
		while (!q.isEmpty()) {
			Position pos = q.poll();
			
//			System.out.println(pos);
			for (int i = 0; i < 6; i++) {
				nh = pos.h + directions[i][0];
				ny = pos.y + directions[i][1];
				nx = pos.x + directions[i][2];

				if (!isRange(nh, ny, nx))
					continue;

				if (!visited[nh][ny][nx] && map[nh][ny][nx] == '.') {
					visited[nh][ny][nx] = true;
					q.offer(new Position(nh, ny, nx, pos.cnt + 1));
				}

				if (map[nh][ny][nx] == 'E') {
					ans = pos.cnt + 1;
					q.clear();
					return;
				}
			}

		}
	}

	private static boolean isRange(int nh, int ny, int nx) {
		if (nh < 0 || nh == H || ny < 0 || ny == R || nx < 0 || nx == C)
			return false;
		return true;
	}

	static class Position {
		int y, x, h, cnt;

		Position(int h, int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.h = h;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + ", h=" + h + ", cnt=" + cnt + "]";
		}

	}
}
