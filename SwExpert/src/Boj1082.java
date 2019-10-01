import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1082 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] map;
	static int N, M;
	static boolean[][][] visited;
	static Queue<Pair>[] fireList;
	static Pair start;
	static Pair destination;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[2][N][M];
		fireList = new LinkedList[10000];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < fireList.length; i++) {
			fireList[i] = new LinkedList<>();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'D') {
					destination = new Pair(i, j);
				} else if (map[i][j] == '*') {
					fireList[0].add(new Pair(i, j));
					visited[1][i][j] = true;
				} else if (map[i][j] == 'S') {
					start = new Pair(i, j);
					visited[0][i][j] = true;
				}
			}
		}

		bfs();
		if(ans==0) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(ans);
		}
	}

	private static void bfs() {
		Queue<Pair>[] q = new LinkedList[10000];
		for (int i = 0; i < q.length; i++) {
			q[i] = new LinkedList<>();
		}
		q[0].offer(start);
		int ny, nx;
		for (int i = 0; i < fireList.length-1; i++) {
//			System.out.println(i);
			while (!fireList[i].isEmpty()) {
				Pair p = fireList[i].poll();
//				System.out.println("fire :: " + p);
				for (int d = 0; d < 4; d++) {
					ny = p.y + dy[d];
					nx = p.x + dx[d];
					if (!isRange(ny, nx))
						continue;
					
					if (!visited[1][ny][nx] && map[ny][nx] == '.') {
						fireList[i + 1].add(new Pair(ny, nx));
						visited[1][ny][nx] = true;
					}

				}
			} // 불 퍼트리기
			while (!q[i].isEmpty()) {
				Pair p = q[i].poll();
//				System.out.println("person :: " + p);
//				if (p.x == destination.x && p.y == destination.y) {
//					ans = i;
//					System.out.println(p.x + "  " + p.y);
//					return;
//				}
				for (int d = 0; d < 4; d++) {
					ny = p.y + dy[d];
					nx = p.x + dx[d];
					if(ny == destination.y && nx == destination.x) {
						ans = i+1;
						return;
					}
					if (!isRange(ny, nx))
						continue;

					if (!visited[0][ny][nx] && !visited[1][ny][nx] && map[ny][nx] == '.') {
						q[i + 1].add(new Pair(ny, nx));
						visited[0][ny][nx] = true;
					}

				}
			}
		}

	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == M)
			return false;
		return true;
	}

	static class Pair {
		int y, x;

		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Pair [y=" + y + ", x=" + x + "]";
		}

	}
}
