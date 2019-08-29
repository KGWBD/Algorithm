import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem1244 {
	static int max;
	static int tempN;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static Set<String>[] set;

	public static void main(String[] args) throws IOException {

		int testCase = Integer.parseInt(br.readLine());
		int cnt;
		for (int t = 1; t <= testCase; t++) {

			st = new StringTokenizer(br.readLine());
			String[] arr = st.nextToken().split("");
			cnt = Integer.parseInt(st.nextToken());
			max = -1;
			int length = arr.length;
			set = new HashSet[cnt + 1];
			for (int i = 0; i <= cnt; i++) {
				set[i] = new HashSet<>();
			}
			dfs(arr,cnt, 0);
			System.out.format("#%d %d\n", t, max);
		}
	}

	private static void dfs(String[] arr, int cnt, int change) {
		String temp = "";
		if (cnt == 0) {

			for (String s : arr) {
				temp += s;
			}

			if (max < Integer.parseInt(temp)) {
				max = Integer.parseInt(temp);
			}

			return;
		}
		String tmp = "";
		for (int i = 0; i < arr.length; i++) {
			tmp += arr[i];
		}
		if (set[change].add(tmp)) {
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					swap(arr, j, i);
					dfs(arr, cnt - 1, change + 1);
					swap(arr, i, j);
				}
			}
		}
	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
