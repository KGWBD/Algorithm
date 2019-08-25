import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
//		int tc = 1;
		for (int t = 1; t <= tc; t++) {
			char[] c = br.readLine().toCharArray();
			int hire = 0;
			int sum = c[0] - '0';
			
			for(int i = 1 ; i < c.length; i++) {
				if(c[i]-'0'>0) {
					if(sum<i) {
						hire += i- sum;
						sum+=c[i]-'0' + i-sum;
					} else {
						sum+=c[i] -'0';
					}
				}
			}
			System.out.format("#%d %d\n",t,hire);
			
		} // tc
	}
}
