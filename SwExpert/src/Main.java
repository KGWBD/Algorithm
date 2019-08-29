import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,L;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			p = new int[N];
			
			int idx = 0;
			int cnt = 0;
			while(true) {
				p[idx]++;
				if(p[idx]==M)break;
				cnt++;
				if(p[idx]%2==0)idx -=L; 		//값이 짝수일 때	
				 else idx +=L;			//값이 홀수일 때
					
				if(idx>=N)idx %= N;
				else if(idx<0)idx = N+idx;
				
				
			}
			System.out.println(cnt);
		
	}
}
