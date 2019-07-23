import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem5432 {
	public static void main(String[] args) throws IOException {
		Stack<String> stack = new Stack<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {

			String[] strs = br.readLine().split("");
			int total = 0;
			for (int i = 0; i < strs.length; i++) {
				if ("(".equals(strs[i])) {
					stack.push(strs[i]);
					System.out.println("stack size :" + stack.size());
					if (")".equals(strs[i + 1])) {
						stack.pop();
						total += stack.size();
						i++;
					}
				} else {
					stack.pop();
					total += 1;

				}

			}
			System.out.println(String.format("#%d %d", t, total));

		}

	}

}
