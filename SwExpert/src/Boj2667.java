import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj2667 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static int cnt;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		visited = new boolean[N][N];
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1') {
					cnt = 1;
					map[i][j]='0';
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int n:list) {
			System.out.println(n);
		}

	}

	private static void dfs(int y, int x) {
		int ty, tx;
		for (int d = 0; d < 4; d++) {
			ty = y + dy[d];
			tx = x + dx[d];

			if (!isRange(ty, tx)) {
				continue;
			}
			if (map[ty][tx] == '1') {
				cnt++;
				map[ty][tx] = '0';
				dfs(ty, tx);
			}
		}

	}

	private static boolean isRange(int ty, int tx) {
		if (ty < 0 || ty == N || tx < 0 || tx == N)
			return false;
		return true;
	}
}
