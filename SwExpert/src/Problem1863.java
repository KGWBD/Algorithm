import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem1863 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] p;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N + 1];

		makeSet();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			union(n1, n2);
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (p[i] == i)
				cnt++;
		}
		System.out.println(cnt);

	}

	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}

	static int findSet(int x) {
		if (p[x] == x)
			return x;
		int idx = findSet(p[x]);
		p[x] = idx;
		return idx;
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px != py) {
			p[py] = px;
		}
	}

}
