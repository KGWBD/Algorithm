import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj8959 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			String in = br.readLine();
			int sum = 0;
			int cnt = 0;

			for (int i = 0; i < in.length(); i++) {
				if (in.charAt(i) == 'O') {
					cnt++;
					sum += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(sum);
		}
	}
}
