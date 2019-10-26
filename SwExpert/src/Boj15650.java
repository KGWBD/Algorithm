import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15650 {
	static int[] arr;
	static boolean[] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		permu(1, 0);

	}

	private static void permu(int depth, int cnt) {
		if (depth == N + 1 && cnt != M) {
			return;
		}

		if (cnt == M) {
			for(int i =1 ; i <=N; i++) {
				if(visited[i]) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
			
			return;
		}
		visited[depth] = true;
		permu(depth + 1, cnt + 1);
		visited[depth] = false;
		permu(depth + 1, cnt);

	}
}
