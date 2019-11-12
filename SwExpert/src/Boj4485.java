import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4485 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int[][] value;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = 0;
		while (true) {
			tc++;
			N = Integer.parseInt(br.readLine());
			if(N==0)break;
			map = new int[N][N];
			value = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(value[i], INF);
			}
			bfs(0, 0);
			bw.write("Problem "+tc+": "+value[N-1][N-1]+"\n");
		}
		bw.close();
	}

	private static void bfs(int y, int x) {
		Queue<Position> q = new LinkedList<Boj4485.Position>();
		q.offer(new Position(y, x));
		value[y][x] = map[y][x];
		int ny, nx;
		Position pos;
		while (!q.isEmpty()) {
			pos = q.poll();

			for (int i = 0; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];

				if (!isRange(ny, nx))
					continue;

				if (value[ny][nx] > value[pos.y][pos.x] + map[ny][nx]) {
					value[ny][nx] = value[pos.y][pos.x] + map[ny][nx];
					q.offer(new Position(ny, nx));
				}

			}
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
