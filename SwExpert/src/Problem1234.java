import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem1234 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		LinkedList<String> list = null;

		for (int t = 1; t <= 10; t++) {

			st = new StringTokenizer(br.readLine());
			list = new LinkedList<String>();
			int len = Integer.parseInt(st.nextToken());
			String[] str = st.nextToken().split("");

			for (int i = 0; i < str.length; i++) {
				list.add(str[i]);
			}
			boolean flag = true;
			String s1, s2;
			outer: while (flag) {

				for (int i = 0; i < list.size() - 1; i++) {
					s1 = list.get(i);
					s2 = list.get(i + 1);
					if (s1.equals(s2)) {
						list.remove(i + 1);
						list.remove(i);
						continue outer;
					}
				}//for
				flag = false;
			} //while
			System.out.format("#%d ",t);
			for (String s : list) {
				System.out.print(s);
			}
			System.out.println();

		} // for

	}
}
