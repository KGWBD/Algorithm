import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem3752 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Set<Integer> set;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			
			
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max += arr[i];
			}
			boolean[] chk = new boolean[max+1];
			chk[0] = true;
			
			for(int i = 0 ; i < N; i++) {
				for(int j = max; j>=0 ; j--) {
					if(chk[j]) {
						chk[j+arr[i]] = true;
					}
				}
			}
			int ans = 0;
			for(boolean b:chk) {
				if(b)ans++;
			}
			bw.write("#"+t+" " + ans + "\n");
			
		}//testCase
		bw.close();
	}
}
