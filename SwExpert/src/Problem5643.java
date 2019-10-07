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

public class Problem5643 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer>[] list_reverse;
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	static int[] dist_reverse;
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			
			list = new ArrayList[N+1];
			list_reverse = new ArrayList[N+1];
			
			int a,b;
			for(int i = 1; i<= N; i++) {
				list[i] = new ArrayList<>();
				list_reverse[i] = new ArrayList<>();
			} 
			
			for(int i = 0; i <M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list_reverse[b].add(a);
			} // graph 생성
			
			int ans = 0;
			for(int i = 1; i<=N;i++) {
				dist = new int[N+1];
				dist_reverse = new int[N+1];
				Arrays.fill(dist, INF);
				Arrays.fill(dist_reverse, INF);
				dijstra(i,list,dist);
				dijstra(i,list_reverse,dist_reverse);
				int cnt = 0;
				for(int n:dist) {
					if(n!=INF)cnt++;
				}
				for(int n:dist_reverse) {
					if(n!=INF)cnt++;
				}
				if(cnt==N-1)ans++;
				
			}
			bw.write("#"+t+" ");
			bw.write(ans + "\n");
		}//testCase
		bw.close();
	}

	private static void dijstra(int start, ArrayList<Integer>[] li,int[] dis) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		dis[start] = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 0 ; i < li[now].size();i++) {
				int temp = li[now].get(i);
				
				if(dist[temp] > dist[now] + 1) {
					dist[temp] = dist[now] +1;
					q.offer(temp);
				}
			
			}
		}
		dis[start] = INF;
	}

}
