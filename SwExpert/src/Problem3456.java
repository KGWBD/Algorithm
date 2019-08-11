import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem3456 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Set<String> set = null;

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {

			st = new StringTokenizer(br.readLine());
			set = new HashSet<String>();
			String s = null;
			boolean flag=false;
			while (st.hasMoreTokens()) {
				s = st.nextToken();
				flag = set.add(s);
				if(!flag) {
					set.remove(s);
				}
				
			}
			System.out.format("#%d %s",t,set.toArray()[0]);
		}
	}
}
