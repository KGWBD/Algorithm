import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem2105 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int[] dx = { 1, -1, -1, 1 };
	static int[] dy = { 1, 1, -1, -1 };
	static int N;
	static int ans; 

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans= Integer.MIN_VALUE;
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					Set<Integer> set = new HashSet<>();
					set.add(map[i][j]);
					dfs(i, j, i, j, 0, set);
				}
			}
			if(ans==Integer.MIN_VALUE)ans = -1;
			bw.write("#"+t+" ");
			bw.write(ans + "\n");
		}
		bw.close();
	}

	private static void dfs(int y, int x, int destY, int destX, int dir, Set<Integer> set) {
		for (int i = 0; i < 2; i++) {
			if (dir + i < 4) {
				int ny = y + dy[dir + i];
				int nx = x + dx[dir + i];
				
				if(ny==destY && nx==destX) {
					int size = set.size();
					if(ans<size)ans=size;
					return;
				}
				
				if (isRange(ny, nx)) {
					if (!set.contains(map[ny][nx])) {
						set.add(map[ny][nx]);
						dfs(ny, nx, destY, destX, dir + i, set);
						set.remove(map[ny][nx]);
					}
				}
			}
		}

	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == N)
			return false;
		return true;
	}
}
