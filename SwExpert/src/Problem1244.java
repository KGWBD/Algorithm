import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1244 {
	static int max;
	static int tempN;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int testCase = Integer.parseInt(br.readLine());
		int cnt;
		for (int t = 1; t <= testCase; t++) {

			st = new StringTokenizer(br.readLine());
			String[] arr = st.nextToken().split("");
			cnt = Integer.parseInt(st.nextToken());
			max = -1;
			int length = arr.length;
			while(cnt - (length-1) >= 2) {
				cnt -= 2;
			}
			dfs(arr, cnt);
			System.out.format("#%d %d\n", t, max);
		}
	}

	private static void dfs(String[] arr, int cnt) {
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
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
					swap(arr, j, i);
					dfs(arr, cnt - 1);
					swap(arr, i, j);
			}
		}
	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
