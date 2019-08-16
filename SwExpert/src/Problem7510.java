import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem7510 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {

			int num = Integer.parseInt(br.readLine());
			int maxVal = (num + 1) / 2;
			int ans = 0;
			int Sn=0;
			int Sr=1;	
			if (num == 1) {
				ans++;
				System.out.format("#%d %d\n", t, ans);
				continue;
			}
			for (int i = 1; i <= maxVal + 1; i++) {

				Sn+=i;
				while (Sn >= num) {
					
					if(Sn==num) ans++;
					Sn-=Sr++;
					
				}

			}
			ans++;
			System.out.format("#%d %d\n", t, ans);

		}

	}
}
