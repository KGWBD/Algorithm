import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1965 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS();
	}
	private static void LIS() {
		int[] dp = new int[n];
		dp[0] = arr[0];
		int idx = 0;
		
		for(int i = 1; i < arr.length;i++) {
			
			if(dp[idx]<arr[i]) {
				dp[++idx] = arr[i];
			} else {
				int ii = lower_bound(dp,idx,arr[i]);
				dp[ii] = arr[i];
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(idx+1);
	}
	private static int lower_bound(int[] dp, int end, int val) {
		int start = 0;
		while(start<end) {
			int mid = (start+end)/2;
			if(dp[mid]>=val) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		return end;
	}
}
