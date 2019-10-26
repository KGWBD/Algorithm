import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem4008 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] operation;
	static int[] operator;
	static int N;
	static boolean[] visited;
	static int[] permutation;
	static int max_ans;
	static int min_ans;
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			min_ans = Integer.MAX_VALUE;
			max_ans = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			operation = new int[N];
			operator = new int[N - 1];
			permutation = new int[N - 1];
			visited = new boolean[N - 1];
			set = new HashSet<Integer>();
			st = new StringTokenizer(br.readLine());
			int op = 1;
			for (int i = 0; i < N - 1; i++) {
				int temp = Integer.parseInt(st.nextToken());
				for (int j = 0; j < temp; j++) {
					operator[i++] = op;
				}
				i--;
				op++;
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				operation[i] = Integer.parseInt(st.nextToken());
			}

			permu(0, 0);

			bw.write("#" + t + " ");
			bw.write((max_ans - min_ans) + "\n");
		}
		bw.close();

	}

	private static void permu(int depth, int n) {
		if (depth == N - 1) {
			int temp = operation[0];
			for (int i = 1; i < N; i++) {
				switch (permutation[i - 1]) {
				case 1:
					temp += operation[i];
					break;
				case 2:
					temp -= operation[i];
					break;
				case 3:
					temp *= operation[i];
					break;
				case 4:
					temp /= operation[i];
					break;
				}
			}

			if (temp < min_ans)
				min_ans = temp;
			if (temp > max_ans)
				max_ans = temp;
			return;
		}

		if (set.add(n)) {
			for (int i = 0; i < N - 1; i++) {
				if (!visited[i]) {
					visited[i] = true;
					permutation[depth] = operator[i];
					permu(depth + 1, n * 10 + permutation[depth]);
					visited[i] = false;
				}
			}
		}

	}
}