import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj15651{
	static int[] arr;
	static boolean[] visited;
	static int N,M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N =  Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		visited = new boolean[N+1];
		permu(1,0);
		bw.close();
		
	}
	
	private static void permu(int depth, int cnt) throws IOException {
		if(depth==N+1 && cnt!=M) {
			return;
		}
		
		if(cnt==M) {
			for(int i = 1; i <= M; i++) {
				bw.write(arr[i]+ " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 1 ; i <= N ; i++) {
				arr[depth] = i;
				permu(depth+1,cnt+1);
			}
		}
		
		
}
