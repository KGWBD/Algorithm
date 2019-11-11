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

public class Boj2933 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R, C;
	static char[][] map;
	static boolean[][] checkClu;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] cluster;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int cycle = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int c = 0; c < cycle; c++) {

			int height = R - Integer.parseInt(st.nextToken());

			if (c % 2 == 0) { // 왼쪽에서 던짐
				for (int j = 0; j < C; j++) {
					if (map[height][j] == 'x') {
						map[height][j] = '.';
						break;
					}
				}
			} else {// 오른쪽에서 던짐
				for (int j = C - 1; j >= 0; j--) {
					if (map[height][j] == 'x') {
						map[height][j] = '.';
						break;
					}
				}
			}
			
			checkClu = new boolean[R][C];
			for (int j = 0; j < C; j++) {
				if (map[R - 1][j] == 'x') {
					checkCluster(j);
				}
			}
//			printMap();
//			printClu();

			cluster = new int[R][C];
			int clusterNum = 1;
			for (int i = R - 2; i >= 0; i--) {
				for (int j = 0; j < C; j++) {
					if (!checkClu[i][j] && cluster[i][j] == 0 && map[i][j] == 'x') {
						identifyCluster(i, j, clusterNum);
						clusterNum++;
					}

				}
			}
//			printCluster();
			boolean flag;
			Position pos;
			int y, x;
			LinkedList<Position> list = new LinkedList<>();
			while (true) {
				int cnt = 0;
				outer: for (int k = 1; k < clusterNum; k++) {
					flag = false;
					for (int i = R - 1; i >= 0; i--) {
						for (int j = 0; j < C; j++) { // 한줄
							if(i==R-1 && cluster[i][j]==k)continue outer;
							if (cluster[i][j] == k) {
								if (cluster[i+1][j]!=k && map[i + 1][j] == 'x') {
									flag = true;
								} else {
//									System.out.println("i :: " + i + " j :: " + j);
									list.add(new Position(i, j));
								}
							} // 현재 자기 클러스터라면
						} // 한줄
					}
					if (flag) {
						continue outer;
					} else {
						while (!list.isEmpty()) {
							pos = list.poll();
//							System.out.println(pos);
							y = pos.y;
							x = pos.x;
							map[y + 1][x] = 'x';
							map[y][x] = '.';
							cluster[y + 1][x] = k;
							cluster[y][x] = 0;
							cnt++;
						}
					}
				}
				if (cnt == 0)
					break;
			}
//			printMap();

		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				bw.write(map[i][j]);
			}
			bw.write("\n");
		}
		bw.close();

	}

	private static void identifyCluster(int y, int x, int num) {
		Queue<Position> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		visited[y][x] = true;
		cluster[y][x] = num;
		q.offer(new Position(y, x));
		int ny, nx;
		Position pos;
		while (!q.isEmpty()) {
			pos = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];

				if (!isRange(ny, nx))
					continue;

				if (!visited[ny][nx] && map[ny][nx] == 'x') {
					visited[ny][nx] = true;
					cluster[ny][nx] = num;
					q.offer(new Position(ny, nx));
				}
			}

		}

	}

	private static void checkCluster(int col) {
		Queue<Position> q = new LinkedList<>();
		checkClu[R - 1][col] = true;
		q.offer(new Position(R - 1, col));
		int ny, nx;
		Position pos;
		while (!q.isEmpty()) {
			pos = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];

				if (!isRange(ny, nx))
					continue;

				if (!checkClu[ny][nx] && map[ny][nx] == 'x') {
					checkClu[ny][nx] = true;
					q.offer(new Position(ny, nx));
				}
			}

		}

	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || nx < 0 || ny == R || nx == C)
			return false;
		return true;
	}

	private static void printMap() {
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("==========================");
	}

	private static void printCluster() {
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(cluster[i]));
		}
		System.out.println("==========================");
	}

	private static void printClu() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (checkClu[i][j]) {
					System.out.print("O");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		System.out.println("==========================");
	}

	static class Position {
		int y, x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + "]";
		}

	}
}
