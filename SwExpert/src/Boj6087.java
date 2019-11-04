import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj6087 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static int[][][] value;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int R, C;
	static int ans;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		value = new int[4][R][C];
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean isFirst = true;
		int startY = 0, startX = 0, endY = 0, endX = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'C') {
					if (isFirst) {
						startY = i;
						startX = j;
						isFirst = false;
					} else {
						map[i][j] = '.';
						endY = i;
						endX = j;
					}
				}

			}
		}
		for (int k = 0; k < 4; k++) {

			for (int i = 0; i < R; i++) {
				Arrays.fill(value[k][i], Integer.MAX_VALUE);
			}
		}
		Queue<Mirror> q = new LinkedList<Boj6087.Mirror>();
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			value[i][startY][startX] = 0;

			ny = startY + dy[i];
			nx = startX + dx[i];

			if (!isRange(ny, nx))
				continue;

			if (map[ny][nx] == '.') {
				value[i][ny][nx] = 0;
				q.offer(new Mirror(ny, nx, i, 0));
			}
		}
		bfs(q, endY, endX);
		int ans = Integer.MAX_VALUE;
		for(int k = 0 ; k <4; k++) {
			if(ans>value[k][endY][endX])ans = value[k][endY][endX];
		}
		System.out.println(ans);
	}

	private static void bfs(Queue<Mirror> q, int endY, int endX) {
		int ny, nx;
		Mirror mir;
		boolean isTurn;
		while (!q.isEmpty()) {
			mir = q.poll();

			for (int i = 0; i < 4; i++) {
				isTurn = false;
				ny = mir.y + dy[i];
				nx = mir.x + dx[i];
				if (!isRange(ny, nx))
					continue;

				switch (mir.dir) {
				case 0:
					if (i == 1 || i == 3)
						isTurn = true;
					else if (i == 2)
						continue;
					break;
				case 1:
					if (i == 0 || i == 2)
						isTurn = true;
					else if (i == 3)
						continue;
					break;
				case 2:
					if (i == 1 || i == 3)
						isTurn = true;
					else if (i == 0)
						continue;
					break;
				case 3:
					if (i == 0 || i == 2)
						isTurn = true;
					else if (i == 1)
						continue;
					break;
				}

				if (map[ny][nx] == '.') {
					if (isTurn) {
						if (value[i][ny][nx] > value[mir.dir][mir.y][mir.x] + 1) {
							value[i][ny][nx] = value[mir.dir][mir.y][mir.x] + 1;
							q.offer(new Mirror(ny, nx, i, value[i][ny][nx]));
						}
					} else {
						if (value[i][ny][nx] > value[mir.dir][mir.y][mir.x]) {
							value[i][ny][nx] = value[mir.dir][mir.y][mir.x];
							q.offer(new Mirror(ny, nx, i, value[i][ny][nx]));
						}
					}
				}
			}
		}
	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == R || nx < 0 || nx == C)
			return false;
		return true;
	}

	static class Mirror {
		int y, x, dir, cnt;

		Mirror(int y, int x, int dir, int cnt) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Mirror [y=" + y + ", x=" + x + ", dir=" + dir + ", cnt=" + cnt + "]";
		}

	}
}