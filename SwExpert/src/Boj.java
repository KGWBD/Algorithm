import java.util.Scanner;

public class Boj {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {

			int N, M, num, x, y;

			M = sc.nextInt(); // 가로
			N = sc.nextInt(); // 세로
			num = sc.nextInt(); // 배추 개수
			int[][] arr = new int[N][M];
			for (int i = 0; i < num; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				arr[y][x] = 1;
			}
			boolean[][] visit = new boolean[N][M];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visit[i][j] && arr[i][j] == 1) {
						dfs(arr, visit, i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}

	private static void dfs(int[][] arr, boolean[][] visit, int y, int x) {
		if (arr[y][x] == 0) {
			return;
		}

		visit[y][x] = true;
		int ty, tx;
		for (int i = 0; i < 4; i++) {
			ty = y + dy[i];
			tx = x + dx[i];
			if (tx < 0 || tx == arr[1].length || ty < 0 || ty == arr.length) {
				continue;
			}
			if (!visit[ty][tx] && arr[ty][tx] == 1) {
				dfs(arr, visit, ty, tx);
			}
		}

	}
}
