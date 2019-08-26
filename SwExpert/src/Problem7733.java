import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7733 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] checked;
	static int N;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int cnt, max;
	public static void main(String[] args) throws NumberFormatException, IOException {

		int tc = Integer.parseInt(br.readLine());
//		int tc = 1;
		for (int t = 1; t <= tc; t++) {

			N = Integer.parseInt(br.readLine());
			max = 0;
			checked = new boolean[N][N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int n = 0; n <= 100; n++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == n)
							checked[i][j] = true;
					}
				} // 맛있는 정도가 n인 것은 다 방문
				
				cnt = 0;
				visited = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(!checked[i][j] && !visited[i][j]) {
							dfs(i,j);
							cnt++;
						}
						
					}
				}
				if(max<cnt) {
					max = cnt;
				}
			}
			System.out.format("#%d %d\n",t,max);	
		} // testCase;
		
	}

	private static void dfs(int y, int x) {
		
		visited[y][x] = true;
		int tx, ty;
		for (int i = 0; i < 4; i++) {
			ty = y + dy[i];
			tx = x + dx[i];
			if (ty < 0 || ty == N || tx < 0 || tx == N) {
				continue;
			}
			if (!checked[ty][tx] && !visited[ty][tx] ) {
				dfs(ty, tx);
			}
		}
		
	}

}
