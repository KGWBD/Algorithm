import java.util.Scanner;

public class Solution123 {
	static boolean[] visit;
	static int max = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			int y, x;
			int[][] arr = new int[N + 1][N + 1];
			visit = new boolean[N + 1];
			for (int i = 1; i < visit.length; i++) {
				visit[i] = true;
			}

			for (int m = 0; m < M; m++) {
				y = sc.nextInt();
				x = sc.nextInt();
				arr[y][x] = 1;
				arr[x][y] = 1;
			}
			boolean[] visited = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][j] == 1)
						dfs(arr, i, visited, 1);
				}
			}
			System.out.format("#%d ",t);
			System.out.println(max == -1 ? 1 : max);
			
		}
	}

	private static void dfs(int[][] arr, int node, boolean[] visited, int cnt) {
		if (visit[node]) {
			max = Math.max(max, cnt);
			return;
		}
		
		visited[node] = true;
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i] && arr[node][i] == 1) {
				dfs(arr, i, visited, cnt + 1);
			}
		}
		

	}

}
