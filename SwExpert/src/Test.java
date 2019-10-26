import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] dayArr;
	static int[] payArr;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		dayArr = new int[N+1];
		payArr = new int[N+1];
		
		for(int i=1;i <=N;i++) {
			st = new StringTokenizer(br.readLine());
			dayArr[i] = Integer.parseInt(st.nextToken());
			payArr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N ; i++) {
			dfs(i,0);
		}
		System.out.println(max);
	}
	private static void dfs(int day, int pay) {
		if(day>N)return;
		
		pay += payArr[day];
		day += dayArr[day];
		dfs(day,pay);
		
		if(max<pay)max = pay;
	}
}
