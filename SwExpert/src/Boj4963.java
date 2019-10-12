import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4963 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException  {

		while (true) {
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(M==0 && N==0)break;
			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						bfs(i, j,map,visited);
						ans++;
					}
				}
			}
			bw.write(ans + "\n");
		}
		bw.close();

	}

	private static void bfs(int y, int x,int[][] map, boolean[][] visited) {
		visited[y][x] = true;
		Queue<Position> q = new LinkedList<Position>();
		q.offer(new Position(y, x));
		Position pos = null;
		int ny, nx;
		while (!q.isEmpty()) {
			pos = q.poll();

			for (int i = 0; i < 8; i++) {

				ny = pos.y + dy[i];
				nx = pos.x + dx[i];

				if (!isRange(ny, nx))
					continue;

				if (!visited[ny][nx] && map[ny][nx] == 1) {
					visited[ny][nx] = true;
					q.offer(new Position(ny, nx));
				}
			}
		}
	}
	private static boolean isRange(int ny, int nx) {
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