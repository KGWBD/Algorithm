import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1719 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Node>[] map;
	static String[] ans;
	static int[] dist;
	static int N,M;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1];
		for(int i = 1; i <N+1; i++) {
			map[i] = new ArrayList<>();
		}
		
		int now,next,value;
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			now = Integer.parseInt(st.nextToken());
			next = Integer.parseInt(st.nextToken());
			value = Integer.parseInt(st.nextToken());
			map[now].add(new Node(next,value,0));
			map[next].add(new Node(now,value,0));
		}
		
		
		
		for(int i = 1 ; i <= N; i++) {
			ans = new String[N+1];
			Arrays.fill(ans, "-");
			dist = new int[N+1];
			Arrays.fill(dist, INF);
			dijstra(i);	
			printAns();
//			System.out.println(Arrays.toString(dist));
		}
		bw.close();
		
	}
	private static void printAns() throws IOException {
		for(int i = 1; i <= N ; i++) {
				bw.write(ans[i] + " ");
		}
		bw.write("\n");
	}
	
	private static void dijstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start,dist[start],0));
		Node now,next;
		int size = 0;
		while(!pq.isEmpty()) {
			now = pq.poll();
			size = map[now.index].size();
			
			for(int i = 0; i < size;i++) {
				next = map[now.index].get(i);
				
				if(dist[next.index] > dist[now.index] + next.value) {
					dist[next.index] = dist[now.index] + next.value;
					if(now.cnt==0) {
						pq.offer(new Node(next.index,dist[next.index],next.index));
						ans[next.index] = String.valueOf(next.index);
					}
					else {
						pq.offer(new Node(next.index,dist[next.index],now.cnt));
						ans[next.index] = String.valueOf(now.cnt);
					}
				}
			}
		}
		
	}
	static class Node implements Comparable<Node>{
		int index,value,cnt;
		Node(int index,int value,int cnt){
			this.index = index;
			this.value = value;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Node o) {
			return value-o.value;
		}

		@Override
		public String toString() {
			return "Node [index=" + index + ", value=" + value + "]";
		}
		
	}
	
}
