import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1213 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int i = 1; i <= 10; i++) {
			int tc = Integer.parseInt(br.readLine());
			String s = br.readLine();
			String str = br.readLine();
			int cnt = 0;

			while (str.contains(s)) {
				cnt++;
				str = str.substring(0, str.lastIndexOf(s));
			}
			System.out.format("#%d %d\n",i,cnt);

		}

	}

}