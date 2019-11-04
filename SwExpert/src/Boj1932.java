import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1932 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] list;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		list = new int[N][N];
		dp = new int[N][N];
		int size;
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			size = st.countTokens();
			for(int j = 0 ; j < size; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(list[i]));
		}
		
		dp[0][0] = list[0][0];
		
		for(int i = 0; i < N-1; i++) {
			for(int j = 0 ; j <= i+1; j++) {
				
				if(j==0) {
					dp[i+1][0] = list[i+1][0] + dp[i][0];
				} else if(j==i+1) {
					dp[i+1][j] = list[i+1][j] + dp[i][j-1];
				} else {
					dp[i+1][j] = list[i+1][j] + Math.max(dp[i][j-1], dp[i][j]);
				}
			}
		}
		for(int i = 0 ; i <N ;i++) {
			if(ans<dp[N-1][i])ans = dp[N-1][i];
		}
		bw.write(ans+"\n");
		bw.close();
		
	}
	
	
}
