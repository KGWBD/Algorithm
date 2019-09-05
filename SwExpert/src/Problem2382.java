import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Problem2382 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Node> list;
	static ArrayList<Node> newList;
	static int N, M, K;
	static int[][] map;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			list = new ArrayList<Problem2382.Node>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				list.add(new Node(y, x, val, dir));
			}
			for (int i = 0; i < M; i++) {
				int[][] arr = new int[N][N];
				move(arr);
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						if (arr[y][x] > 1) {
							merge(y, x);
						}

					}
				}

			}

			int sum = 0;
			for (Node n : list) {
				sum += n.val;
			}
			System.out.format("#%d %d\n", t, sum);
		}

	}

	private static void merge(int y, int x) {
		newList = new ArrayList<>();
		int sumVal = 0;
		int dir = 0;
		for (Node n : list) {
			if (n.y == y && n.x == x) {
				newList.add(n);
			}
		}
		Collections.sort(newList);
		for (Node n : newList) {
			list.remove(n);
			sumVal += n.val;
			dir = n.dir;
		}
		list.add(new Node(y, x, sumVal, dir));
	}

	private static void move(int[][] arr) {
		Iterator<Node> it = list.iterator();
		int ty, tx;
		while (it.hasNext()) {

			Node n = it.next();
			ty = n.y + dy[n.dir];
			tx = n.x + dx[n.dir];
			if (inCell(ty, tx)) {
				n.x = tx;
				n.y = ty;
				n.dir = chageDir(n.dir);
				n.val = n.val / 2;
			}
			n.x = tx;
			n.y = ty;
			arr[ty][tx]++;
		}

	}

	private static int chageDir(int dir) {
		switch (dir) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return 0;

	}

	private static boolean inCell(int ty, int tx) {
		boolean flag = false;

		if (ty == 0 || ty == N - 1 || tx == 0 || tx == N - 1) {
			flag = true;
		}

		return flag;
	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int val;
		int dir;

		Node(int y, int x, int val, int dir) {
			this.y = y;
			this.x = x;
			this.val = val;
			this.dir = dir;
		}
		@Override
		public int compareTo(Node o) {
			return val - o.val;
		}

	}
}
