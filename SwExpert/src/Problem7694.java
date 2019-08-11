import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7694 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {

			st = new StringTokenizer(br.readLine());
			int city = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			String[] cities = new String[city + 2];
			cities[0] = cities[cities.length - 1] = "1";

			for (int i = 1; i < city + 1; i++) {
				cities[i] = st.nextToken();
			}
			String tmp;
			int cnt = 0;
			int j;

			outer: for (int i = 0; i < cities.length - 1; i++) {
				tmp = cities[i];
				for (j = i + 1; j <= distance + i; j++) {
					if (j >= cities.length)
						break outer;
					if (cities[j].equals("1")) {
						i = j - 1;
						continue outer;
					}
				}
				cnt++;
				i = j - 2;
			}

			System.out.format("#%d %d\n",t,cnt);
		}
	}

}
