import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3975 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int testCase = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCase; i++) {

			st = new StringTokenizer(br.readLine());
			double n1, n2;
			while (st.hasMoreTokens()) {
				n1 = Double.parseDouble(st.nextToken()) / Integer.parseInt(st.nextToken());
				n2 = Double.parseDouble(st.nextToken()) / Integer.parseInt(st.nextToken());
				System.out.print("#"+i);
				if (n1 > n2) {
					System.out.println(" ALICE");
				} else if (n1 == n2) {
					System.out.println(" DRAW");
				} else {
					System.out.println(" BOB");
				}
			}

		}
	}
}
