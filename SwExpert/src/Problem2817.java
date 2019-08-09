import java.util.Scanner;

public class Problem2817 {
	static int K;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		int[] arr;
		boolean[] visited;

		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {

			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			visited = new boolean[N];
			ans = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			powerSet(arr, visited, 0);
			System.out.format("#%d %d\n",t,ans);
		}
	}

	private static void powerSet(int[] arr, boolean[] visited, int depth) {
		if (depth == arr.length) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}
			if (sum == K)
				ans++;
			return;
		}

		visited[depth] = true;
		powerSet(arr, visited, depth + 1);
		visited[depth] = false;
		powerSet(arr, visited, depth + 1);

	}
}
