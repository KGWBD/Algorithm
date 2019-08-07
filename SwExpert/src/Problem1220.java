import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1220 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Stack<String> stack = null;
		for (int t = 1; t <= 10; t++) {

			int n = Integer.parseInt(br.readLine());
			String[][] arr = new String[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = st.nextToken();
				}
			}
			int cnt = 0;
			stack = new Stack<String>();
			for (int x = 0; x < n; x++) {
				stack.clear();
				for (int y = 0; y < n; y++) {
					if (arr[y][x].equals("1") && stack.isEmpty()) {
						stack.add("1");
					} else if (arr[y][x].equals("1") && !stack.isEmpty()) {
						stack.pop();
						stack.add("1");
					} else if (arr[y][x].equals("2") && !stack.isEmpty()) {
						stack.pop();
						cnt++;

					}
				}
			}
			System.out.format("#%d %d\n",t,cnt);
		}
	}
}
