import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JO1681 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] dist;
	static int N;
	static int start = 1;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		visited = new boolean[N];
		dist = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j = 0 ; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[start] = true;
		tsp(start,0,0);
		System.out.println(ans);
	}

	private static void tsp(int now, int size,int cost) {
		if(size == N-1) {
			if(dist[now][start]!=0) {
				cost += dist[now][start];
				
				if(ans>cost)ans = cost;
			}
			return;
		}
		
		if(ans<cost)return;
		
		for(int i = 0 ; i < N; i++) {
			if(visited[i]) continue;
			
			if(dist[now][i]!=0) {
				visited[i] = true;
				tsp(i,size+1,cost+dist[now][i]);
				visited[i] = false;
			}
		}
		
	}

	
	
	
}
