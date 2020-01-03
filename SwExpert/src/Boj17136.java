import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj17136 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, K; // N,M은 종이의 크기, K는 색종이의 종류
	static char[][] map;
	static int[] paper;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		N = M = 10;
		K = 5;
		map = new char[N][M];
		paper = new int[5];
		for (int i = 0; i < 5; i++) {
			paper[i] = 5;
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				char temp = st.nextToken().charAt(0);
				if (temp == '1')
					cnt++;
				map[i][j] = temp;
			}
		} // 입력
		dfs(0, cnt, 0);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	private static void dfs(int idx, int cnt, int result) {
		if (idx == 100 || cnt==0) {
			if (result < ans) {
				ans = result;
			}
			return;
		}
		if (result >= ans)
			return;
		// map을 일단 다 돈다..
		// 1을 만난다.
		// check를 한다. k가 1~5일 때 색종이를 붙일수있는지.
		// 붙일수있다면 붙이고 다음단계로 넘어간다.이 때 방문체크를 하고 넘어가면서 1의 숫자를 차감한다.
		// 그리고 다음단계는 바로 옆.. 1인지를 체크하면서 넘긴다.
		int r = idx / N;
		int c = idx % M;
		char temp = '\u0000';
		temp = map[r][c];
		if (temp == '1') {
				for (int k = K; k >0; k--) {
					if (!isRange(r, c, k) || !remain(k))
						continue;
					if (check(r, c, k)) {
						attatch(r, c, k);
						paper[k - 1]--;
						dfs(idx + 1, cnt - (k * k), result + 1);
						cut(r, c, k);
						paper[k - 1]++;
					}
				}
		} else {
			dfs(idx+1,cnt,result);
		}
	}

	private static boolean remain(int k) {
		if (paper[k - 1] <= 0) {
			return false;
		}
		return true;
	}

	private static boolean isRange(int i, int j, int k) {
		if (i + k > N || j + k > M)
			return false;
		return true;
	}

	private static void attatch(int y, int x, int k) {
		for (int i = y; i < y + k; i++) {
			for (int j = x; j < x + k; j++) {
				map[i][j]='0';
			}
		}
	}

	private static void cut(int y, int x, int k) {
		for (int i = y; i < y + k; i++) {
			for (int j = x; j < x + k; j++) {
				map[i][j]='1';
			}
		}
	}

	private static boolean check(int y, int x, int k) {
		for (int i = y; i < y + k; i++) {
			for (int j = x; j < x + k; j++) {
				if (map[i][j] == '0')
					return false;
			}
		}
		return true;
	}
}