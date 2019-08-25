import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem7728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = null;
		int tc = Integer.parseInt(br.readLine());
//		int tc = 1;
		for (int t = 1; t <= tc; t++) {
			set = new HashSet<String>();
			String[] num = br.readLine().split("");
			int ans = 0;
			for(int i = 0 ; i < num.length;i++) {
				
				if(set.add(num[i])) {
					ans++;
				}
			}
			System.out.format("#%d %d\n",t,ans);
			
			
			
			
		} // tc
	}
}
