import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15654 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static int N,M;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		result = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		permu(0,0);
		bw.close();
		
		
	}
	private static void permu(int depth, int cnt) throws IOException {
		if(depth==N && cnt!=M) {
			return;
		}
		
		if(cnt==M) {
			for(int i = 0 ; i < M ; i++) {
				bw.write(result[i]+ " ");
			}
			bw.write("\n");
		}
		
		
		for(int i = 0 ; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				permu(depth+1, cnt+1);
				visited[i] = false;
			}
		}
		
	}
}
