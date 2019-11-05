import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem5656 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Number>[] list;
	static int[] outer;
	static int N, W, H;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			outer = new int[N];
			list = new ArrayList[W];
			for (int i = 0; i < W; i++) {
				list[i] = new ArrayList<>();
			}

			int n;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					n = Integer.parseInt(st.nextToken());
					if (n != 0)
						list[j].add(0, new Number(n));
				}
			}
//			for (int i = 0; i < W; i++) {
//				System.out.println(list[i]);
//			}
			permutation(0);
			
			bw.write("#" + t + " ");
			bw.write(ans + "\n");
		}
		bw.close();

	}

	private static void permutation(int depth) {
		if (depth == N) {
			int[] tempArr = Arrays.copyOf(outer, N);
			ArrayList<Number>[] tempList = copyList();
//			System.out.println(Arrays.toString(tempArr));
			crash(tempArr, tempList);
			return;
		}

		for (int i = 0; i < W; i++) {
			outer[depth] = i;
			permutation(depth + 1);
		}

	}

	private static void crash(int[] arr, ArrayList<Number>[] li) {
		int y, x, ball, sum;
		for (int g = 0; g < N; g++) {
			x = arr[g];
			y = li[x].size() - 1;
			if (y < 0)
				continue;
			ball = li[x].get(y).val;
			bfs(y, x, ball, li);
		}
		sum = 0;
		for (int i = 0; i < W; i++) {
			sum += li[i].size();
		}
//		for (int i = 0; i < W; i++) {
//			System.out.println(li[i]);
//		}
		if (sum < ans) {

			ans = sum;
		}
	}

	private static void bfs(int y, int x, int ball, ArrayList<Number>[] li) {
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(y, x, ball - 1));
		boolean[][] visited = new boolean[H][W];
		ArrayList<Number>[] boomList = new ArrayList[W];
		for (int i = 0; i < W; i++) {
			boomList[i] = new ArrayList<Number>();
		}
		visited[y][x] = true;
		int ny, nx, cnt;
		Position pos;
		while (!q.isEmpty()) {
			pos = q.poll();
			boomList[pos.x].add(li[pos.x].get(pos.y));
			cnt = pos.cnt;
			outer: for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= pos.cnt; j++) {
					ny = pos.y + j * dy[i];
					nx = pos.x + j * dx[i];
					if (!isRange(ny, nx))
						continue outer;

					if (!visited[ny][nx] && li[nx].size() > ny && li[nx].get(ny).val != 0) {
						visited[ny][nx] = true;
						q.offer(new Position(ny, nx, li[nx].get(ny).val - 1));

					}
				}
			}
		}
		for (int i = 0; i < W; i++) {
			li[i].removeAll(boomList[i]);
		}
	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || nx < 0 || ny == H || nx == W)
			return false;
		return true;
	}

	private static ArrayList<Number>[] copyList() {
		ArrayList<Number>[] tempList = new ArrayList[W];
		for (int i = 0; i < W; i++) {
			tempList[i] = new ArrayList<>(list[i]);
		}
		return tempList;
	}

	static class Number {
		int val;

		Number(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "" + val + "";
		}

	}

	static class Position {
		int y, x, cnt;

		Position(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}

	}

}
