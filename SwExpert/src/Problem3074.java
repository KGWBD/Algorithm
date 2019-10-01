import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem3074 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] tK;
	static int[] count;
	static Set<Integer> set;
	static long ans;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		for(int t=1; t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			set = new HashSet<>();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			tK = new int[N];
			count = new int[N];
			for(int i = 0 ; i < N;i++) {
				int N = Integer.parseInt(br.readLine());
				tK[i] = N;
			}
			ans = 0;
			finding(0,20000000000000L);
			System.out.format("#%d %d\n",t,ans);
			
		}//testCase
	}
	private static void finding(long start, long end) {
		if(start==end) {
			ans = start;
			return;
		}
		long mid = (start+end)/2;
		long temp = 0;
		
		for(int i = 0 ; i < N; i++) {
			temp += mid/tK[i];
		}
		
		if(temp<M) {
			finding(mid+1,end);
		} else {
			finding(start,mid);
		}
	}
}