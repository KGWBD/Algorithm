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

public class Main1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static boolean[][][] visited;
	static int[][][] value;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int N, M;
	static int ans = 100000;
	static ArrayList<Position> list;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());// 가로
		N = Integer.parseInt(st.nextToken());// 세로
		visited = new boolean[4][N][M];
		value = new int[4][N][M];
		map = new char[N][M];
		list = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {

				if (map[i][j] == 'C') {
					map[i][j] = '.';
					if (cnt == 1) {
						list.add(new Position(i, j, 0, 0));
					} else {
						cnt++;
						list.add(new Position(i, j, 0, 0));
						list.add(new Position(i, j, 1, 0));
						list.add(new Position(i, j, 2, 0));
						list.add(new Position(i, j, 3, 0));
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		for (Position p : list) {
			System.out.println(p);
		}
		System.out.println("=================");

		bfs();

		bw.write(ans + "\n");
		bw.close();
	}

	private static void bfs() {
		Queue<Position> q = new LinkedList<Main1.Position>();
		Position start;
		for (int i = 0; i < 4; i++) {
			start = list.get(i);
			visited[i][start.y][start.x] = true;
			q.add(start);
		}

		Position pos, end;
		end = list.get(4);
		int ny, nx;
		while (!q.isEmpty()) {
			pos = q.poll();
			System.out.println(pos);

			for (int i = 0; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];

				if (!isRaneg(ny, nx))
					continue;

				if (ny == end.y && nx == end.x) {
					if (pos.dir == i) {
						if (ans > pos.cnt) {
							ans = pos.cnt;
						}
					} else {
						if (ans > pos.cnt + 1) {
							ans = pos.cnt + 1;
						}
					}
				}
				switch (pos.dir) {
				case 0:
					if (i == 1 || i == 3) {
						pos.cnt +=1;
					}
					break;
				case 1:
					if (i == 0 || i == 2) {
						pos.cnt +=1;
					}
					break;
				case 2:
					if (i == 1 || i == 3) {
						pos.cnt +=1;
					}
					break;
				case 3:
					if (i == 0 || i == 2) {
						pos.cnt +=1;
					}
					break;
				}
				if(!visited[i][ny][nx] && value[i][ny][nx]>pos.cnt) {
					value[i][ny][nx] = pos.cnt;
					q.offer(new Position(ny, nx, i, pos.cnt));
				} else if (!visited[i][ny][nx] && map[ny][nx] == '.') {
					visited[i][ny][nx] = true;
					value[i][ny][nx] = pos.cnt;
					q.offer(new Position(ny, nx, i, pos.cnt));
					
				}

			}
		}

	}

	private static boolean isRaneg(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == M)
			return false;
		return true;
	}

	static class Position {
		int y, x, dir, cnt;

		Position(int y, int x, int dir, int cnt) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + ", dir=" + dir + ", cnt=" + cnt + "]";
		}

	}
}
