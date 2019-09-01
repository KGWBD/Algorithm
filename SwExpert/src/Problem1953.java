import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem1953 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dx = { { 0, 1, 0, -1 }, { 0, 0, 0, 0 }, { 0, 1, 0, -1 }, { 0, 1, 0, 0 }, { 0, 1, 0, 0, },
			{ 0, 0, 0, -1 }, { 0, 0, 0, -1 } };
	static int[][] dy = { { -1, 0, 1, 0 }, { -1, 0, 1, 0 }, { 0, 0, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 1, 0 },
			{ 0, 0, 1, 0 }, { -1, 0, 0, 0 } };
	static LinkedList<Pair> node;
	static int N, M, R, C, L, cnt;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			node = new LinkedList<Problem1953.Pair>();
			bfs(R, C, 0);
			System.out.format("#%d %d\n", t, cnt);
		} // testCase

	}

	private static void bfs(int y, int x, int hour) {
		node.offer(new Pair(y, x, map[y][x] - 1, hour));
		cnt++;
		int ty, tx;
		visited[y][x] = true;

		outer: while (!node.isEmpty()) {
			Pair p = node.poll();
//			visited[p.y][p.x] = true;
//			System.out.println("y:: " + p.y + " x:: " + p.x +  " CNT::" +cnt + " houe::" + p.hour);

			for (int i = 0; i < 4; i++) {
				if (p.hour + 1 == L) {
					continue outer;
				}

				ty = p.y + dy[p.cur][i];
				tx = p.x + dx[p.cur][i];
				if (ty < 0 || ty == N || tx < 0 || tx == M) {
					continue;
				}

				if (!visited[ty][tx] && canGo(p.y, p.x, ty, tx, i) && map[ty][tx] != 0) {
					visited[ty][tx] = true;
					cnt++;
					node.offer(new Pair(ty, tx, map[ty][tx] - 1, p.hour + 1));
				}
			}

		}

	}

	private static boolean canGo(int y, int x, int ty, int tx, int dir) {
		boolean flag = true;

		int tur = map[y][x];
		int next = map[ty][tx];
		switch (tur) {
		case 1:
			if (dir == 0) {
				if (next == 3 || next == 4 || next == 7) {
					flag = false;
				}
			} else if (dir == 1) {
				if (next == 2 || next == 4 || next == 5)
					flag = false;
			} else if(dir==2) {
				if(next==3|| next==5 || next==6) flag =false;
			} else {
				if(next==2 || next==6 ||next==7) flag = false;
			}
			break;
		case 2:
			if (dir == 0) {
				if (next == 3 || next == 4 || next == 7)
					flag = false;
			} else if (dir == 2) {
				if (next == 3 || next == 5 || next == 6)
					flag = false;
			} else
				flag = false;
			break;
		case 3:
			if (dir == 1) {
				if (next == 2 || next == 4 || next == 5)
					flag = false;
			} else if (dir == 3) {
				if (next == 2 || next == 6 || next == 7)
					flag = false;
			} else
				flag = false;
			break;
		case 4:
			if (dir == 0) {
				if (next == 3 || next == 4 || next == 7)
					flag = false;
			} else if (dir == 1) {
				if (next == 2 || next == 4 || next == 5)
					flag = false;
			} else
				flag = false;
			break;
		case 5:
			if (dir == 1) {
				if (next == 2 || next == 4 || next == 5)
					flag = false;
			} else if (dir == 2) {
				if (next == 3 || next == 5 || next == 6)
					flag = false;
			} else
				flag = false;
			break;
		case 6:
			if (dir == 2) {
				if (next == 3 || next == 5 || next == 6)
					flag = false;
			} else if (dir == 3) {
				if (next == 2 || next == 6 || next == 7)
					flag = false;
			} else
				flag = false;
			break;
		case 7:
			if (dir == 0) {
				if (next == 3 || next == 4 || next == 7)
					flag = false;
			} else if (dir == 3) {
				if (next == 2 || next == 6 || next == 7)
					flag = false;
			} else
				flag = false;
			break;
		}

		return flag;
	}

	static class Pair {
		int x;
		int y;
		int cur;
		int hour;

		Pair(int y, int x, int cur, int hour) {
			this.x = x;
			this.y = y;
			this.cur = cur;
			this.hour = hour;
		}
	}

}
