import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16509 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static final int N = 10;
	static final int M = 9;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans = Integer.MIN_VALUE;
	static int[][][] dd = { 
			{ { -1, -1 }, { -1, 1 } },
			{ { 1, -1  }, { 1, 1  } },
			{ { -1, -1 }, { 1, -1 } },
			{ { -1, 1  }, { 1, 1  } } };

	public static void main(String[] args) throws IOException {
		map = new int[N][M];
		Queue<Position> q = new LinkedList<Boj16509.Position>();
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		q.offer(new Position(y, x, 0, 0, 0));
		visited[y][x] = true;
		st = new StringTokenizer(br.readLine());
		int kingY = Integer.parseInt(st.nextToken());
		int kingX = Integer.parseInt(st.nextToken());
		map[kingY][kingX] = 1;
		sovle(q, kingY, kingX);
		System.out.println(ans);
	}

	private static void sovle(Queue<Position> q, int kingY, int kingX) {
		int ny, nx;
		Position pos;
		while (!q.isEmpty()) {
			pos = q.poll();

			if (pos.depth == 0) {// 4방향으로 직진할 때
				for (int i = 0; i < 4; i++) {	//4방향
					ny = pos.y + dy[i];
					nx = pos.x + dx[i];
					if (!isRange(ny, nx))
						continue;
					if (map[ny][nx] == 0) {
						q.offer(new Position(ny, nx, i, 1, pos.cnt));
					}
				}

			} else { // 대각선방향으로 움직일 때

				outer:for (int i = 0; i < 2; i++) {
					ny = pos.y;
					nx = pos.x;
					for (int j = 0; j < 2; j++) {
						ny += dd[pos.dir][i][0];
						nx += dd[pos.dir][i][1];
						if (!isRange(ny, nx))
							continue outer;
						
						if (j == 0) {
							if(map[ny][nx]==1) {
								continue outer;
							}
							
						} else {
							if (ny == kingY && nx == kingX) {
								ans = pos.cnt + 1;
								return;
							}

							if (!visited[ny][nx]) {
								visited[ny][nx] = true;
								q.offer(new Position(ny, nx, pos.dir, 0, pos.cnt + 1));
							}
						}
					}

				}

			}

		}

	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
			return false;
		return true;
	}

	static class Position {
		int y, x, depth, dir, cnt;

		Position(int y, int x, int dir, int depth, int cnt) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.depth = depth;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + ", depth=" + depth + ", dir=" + dir + ", cnt=" + cnt + "]";
		}

	}
}
