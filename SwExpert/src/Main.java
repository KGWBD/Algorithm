import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, H;
	static int[][] map;
	static int ans = 1000;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		int y, x;
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map[y - 1][x - 1] = 1;
			map[y - 1][x] = 1;
		}
		if (H != 0) {

			for (int i = 0; i < 4; i++) {
				dfs(0, i);
			}

		} else {
			ans = 0;
		}
		
		if(ans==1000)ans=-1;
		System.out.println(ans);

	}

	private static void dfs(int cnt, int num) {
		if (ans != 1000)
			return;
		
		if (cnt >= num) {
			if (solve()) {
				ans = cnt;
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (j + 1 < M && map[i][j] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 9;
					map[i][j + 1] = 9;
					dfs(cnt + 1, num);
					map[i][j] = 0;
					map[i][j + 1] = 0;
				}

			}
		}

	}

	private static boolean solve() {
		int cnt = 0;
		int var = 1;
		int[][] tempArr = new int[N][M];
		for(int i = 0 ; i < N ;i++) {
			for(int j = 0 ; j < M ; j++) {
				if(cnt==2) {
					cnt=0;
					var++;
				}
				if(map[i][j]!=0) {
					tempArr[i][j] =var;
					cnt++;
				}
			}
		}
//		for(int i = 0 ; i < N ; i++) {
//			System.out.println(Arrays.toString(tempArr[i]));
//		}
//		System.out.println("=================");
		for (int j = 0; j < M; j++) {
//			System.out.println(" j:::::::::::::::::::::: " + j );
			int start = j;
			int depth = 0;
			int temp =0;
			while (depth < N) {
//				System.out.println("   depth :: " + depth + "     start ::  " + start + "    map[depth][start] : : " + tempArr[depth][start] );
				temp = tempArr[depth][start];
				if (temp == 0) { 
					depth++;
				} else {
					if (start - 1 >= 0 && tempArr[depth][start-1] == temp) {
						start--;
						depth++;
					} else if (start + 1 < N && tempArr[depth][start+1] == temp) {
						start++;
						depth++;
					}
				}
			}
			if (start != j) {
				return false;
			}
		}
		return true;

	}
}
