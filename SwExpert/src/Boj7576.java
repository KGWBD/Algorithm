import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj7576 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int row, col;
	static int[][] map;
	static int day;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static LinkedList<Pair> list;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		list = new LinkedList<>();
		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 1) {
					list.add(new Pair(i, j, 0));
				}
			}
		}
		day = 0;

		bfs();
		outer:for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j]==0) {
					day = -1;
					break outer;
				}
			}
		}
		System.out.println(day);
	}

	private static void bfs() {
		int ty, tx;
		while (!list.isEmpty()) {
			Pair q = list.poll();
			if (day < q.cnt)
				day = q.cnt;
			for (int i = 0; i < 4; i++) {
				ty = q.y + dy[i];
				tx = q.x + dx[i];

				if (!isRange(ty, tx)) {
					continue;
				}
				if (map[ty][tx] == 0) {
					list.add(new Pair(ty, tx, q.cnt + 1));
					map[ty][tx] = 1;
				}
			}
		}
	}

	private static boolean isRange(int ty, int tx) {
		if (ty < 0 || ty == row || tx < 0 || tx == col)
			return false;
		return true;
	}

	static class Pair {
		int x, y, cnt;

		Pair(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
