import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem2105 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[][] visited;
	static Set<Integer> dessert;
	static int[][] map;
	static int[] dx = { 1, -1, -1, 1 };
	static int[] dy = { 1, 1, -1, -1 };
	static int N;
	static int startX, startY;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
//		int T = 1;

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = -1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if ((i == 0 && j == 0) || (i == N - 1 && j == 0) || (i == 0 && j == N - 1)
							|| (i == N - 1 && j == N - 1))
						continue;
					else {
						startY = i;
						startX = j;
						dessert = new HashSet<Integer>();
						dfs(i, j, 0);
					}
				}
			}
			System.out.format("#%d %d\n", t, max);
		} // testCase
	}

	private static void dfs(int y, int x, int dir) {
		if (dir == 4)return;
		if(dir==3 && dessert.size()!=0 && startY == y && startX == x) {
			if (max < dessert.size())
				max = dessert.size();
		}

		if (y + dy[dir] < 0 || y + dy[dir] == N || x + dx[dir] < 0 || x + dx[dir] == N) {
			return;
		}
		

		int des = map[y][x];
		
		if(!dessert.contains(des)) {
		dessert.add(des);
		dfs(y + dy[dir], x + dx[dir], dir);
		dfs(y + dy[dir], x + dx[dir], dir + 1);
		dessert.remove(des);
		}
		
	}

}
