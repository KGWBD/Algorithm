import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16234 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		flag = true;
		while (flag) {
			flag = false;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			if(flag)
			ans++;
		}
		System.out.println(ans);
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

	}

	private static void bfs(int y, int x) {
		ArrayList<Position> list = new ArrayList<Boj16234.Position>();
		Queue<Position> q = new LinkedList<Boj16234.Position>();
		list.add(new Position(y, x));
		q.offer(new Position(y, x));
		visited[y][x] = true;
		Position pos;
		int ny, nx;
		int population = map[y][x];
		int cnt = 1;
		while (!q.isEmpty()) {
			pos = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];

				if (!isRange(ny, nx))
					continue;

				if (!visited[ny][nx] && Math.abs(map[pos.y][pos.x] - map[ny][nx]) >= L
						&& Math.abs(map[pos.y][pos.x] - map[ny][nx]) <= R) {
					Position newPos = new Position(ny, nx);
					list.add(newPos);
					q.offer(newPos);
					visited[ny][nx] = true;
					population += map[ny][nx];
					cnt++;
				}
			}
		}
		if (cnt > 1) {
			for (Position p : list) {
				map[p.y][p.x] = population / cnt;
			}
			flag = true;
		}

	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || nx < 0 || ny == N || nx == N)
			return false;
		return true;
	}

	static class Position {
		int y, x;

		Position(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + "]";
		}

	}
}
