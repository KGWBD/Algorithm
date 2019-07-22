import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5356 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = new String[5];
		int testCase = Integer.parseInt(br.readLine());
		int max;
		for (int k = 1; k <= testCase; k++) {
			StringBuilder sb = new StringBuilder();
			max = 0;
			for (int i = 0; i < str.length; i++) {
				str[i] = br.readLine();
				if(max < str[i].length()) max = str[i].length();
			}
			
			for (int x = 0; x < max; x++) {

				for (int y = 0; y < str.length; y++) {
					if (x > str[y].length() - 1) continue;
					
					sb.append(str[y].charAt(x));
				}
			}
			System.out.println(String.format("#%d %s", k, sb.toString()));

		}
	}
}
