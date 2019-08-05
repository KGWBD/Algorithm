package boj;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		boolean[] visited = new boolean[n+1];
		int[][] arr = new int[n + 1][n + 1];
		int[] ver = new int[n + 1];
		for (int i = 1; i < ver.length; i++) {
			ver[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			arr[y][x] = 1;
			arr[x][y] = 1;
		}

		dfs(arr, visited,ver, start);
	}

	private static void dfs(int[][] arr, boolean[] visited,int[] ver, int start) {
		visited[start] = true;

		System.out.print(ver[start] + " ");
		for(int i = 1;i < arr.length;i++) {
			if(!visited[i] && arr[start][i]== 1) {
				dfs(arr,visited,ver,i);
			}
		}

	}

}
