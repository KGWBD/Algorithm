import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2146 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static ArrayList<Pair>[] list;
	static int minDis = Integer.MAX_VALUE;
	static boolean[][] visited;
	static int N;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		map = new int[N][N];
		list = new ArrayList[10001];
		cnt = 1;
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Pair>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}

		for (int c = 1; c < cnt; c++) {
			for (int i = 0; i < list[c].size(); i++) {
				Pair p1 = list[c].get(i);
				int idx = c+1;
				while(idx<cnt) {
					for(int j = 0 ; j< list[idx].size();j++) {
						Pair p2 = list[idx].get(j);
						int dis = Math.abs(p1.x-p2.x) + Math.abs(p1.y - p2.y) -1;
						if(minDis>dis)minDis = dis;
					}
					idx++;
				}
			}
			
		}
		
//		print();
//		System.out.println("--------");
		System.out.println(minDis);
	}

	private static void bfs(int y, int x) {
		list[cnt].add(new Pair(y, x));
		visited[y][x] = true;
		map[y][x] = cnt;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(y, x));
		int ty, tx;
		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				ty = p.y + dy[i];
				tx = p.x + dx[i];

				if (!isRange(ty, tx)) {
					continue;
				}

				if (!visited[ty][tx] && map[ty][tx] != 0) {
					visited[ty][tx] = true;
					q.offer(new Pair(ty, tx));
					map[ty][tx] = cnt;
					list[cnt].add(new Pair(ty, tx));
				}
			}
		}

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean isRange(int ty, int tx) {
		if (ty < 0 || ty == N || tx < 0 || tx == N)
			return false;
		return true;
	}

	static class Pair {
		int x;
		int y;

		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}

	}
}
