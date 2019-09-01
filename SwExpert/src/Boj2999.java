import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2999{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		sb = new StringBuilder();
		
		String s = br.readLine();		
		int N = s.length();
		boolean[] visited = new boolean[N];
		int R,C;
		R = C =0;
		for(int r=0; r<=Math.sqrt(N);r++) {
			for(int c=0;c<=N;c++) {
				if (r<=c && r*c==N) {
					R=r;
					C=c;
				}
			}
		}
		int idx =0;
		int ix = 1;
		while(true) {
			if(visited[idx])break;
			visited[idx]=true;
			sb.append(s.charAt(idx));
			idx+=R;
			if(idx>=s.length()) {
				idx = ix;
				ix++;
			}
		}
		System.out.println(sb.toString());
		
	}
	
	
}