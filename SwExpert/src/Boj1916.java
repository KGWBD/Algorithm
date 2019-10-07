import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1916 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Boj1916.Node>[] list;
	static boolean[][] visited;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	static int nV, nE;
	static ArrayList<Integer> ans;
	static StringBuilder sb;
	static int start,end;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		nV = Integer.parseInt(br.readLine());
		nE = Integer.parseInt(br.readLine());
		visited = new boolean[nV+1][nV+1];
		ans = new ArrayList<Integer>();
		list = new ArrayList[nV+1];
		for(int i = 1 ; i <=nV; i++) {
			list[i] = new ArrayList<Boj1916.Node>();
		}
		dist = new int[nV+1];
		Arrays.fill(dist, INF);
		
		for(int i = 0; i<nE; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[now].add(new Node(next,cost));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijstra(start);
		
		/*
		 * for(int i = 1; i < nV+1;i++) { for(int j = 1 ; j < nV+1;j++) {
		 * System.out.print(visited[i][j]+ " "); } System.out.println(); }
		 */
		
		ans.add(start);
		searchRoute(start);
		System.out.println(dist[end]);
		
		System.out.println(ans.size());
		sb = new StringBuilder();
		for(int n:ans) {
			sb.append(n + " ");
		}
		System.out.println(sb.toString().trim());
	}
	private static void searchRoute(int n) {
		if(n == end) {
			flag = true;
			return;
		}
		
		for(int i = 1; i < nV+1; i++) {
			if(visited[n][i]) {
//				System.out.println("start ::" + n + "   end:: " + i);
				Integer a = new Integer(i);
				ans.add(a);
//				for(int j:ans) {
//					System.out.println(j);
//				}
				searchRoute(i);
				if(flag)break;
				ans.remove(a);
				
			}
		}
	}
	private static void dijstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[start] = 0;
		pq.offer(new Node(start,dist[start]));
		Node node;
		while(!pq.isEmpty()) {
			node = pq.poll();
			for(int i = 0; i< list[node.index].size();i++) {
				Node nextNode = list[node.index].get(i);
				
				if(dist[nextNode.index] >= dist[node.index] + nextNode.cost) {
					dist[nextNode.index] = dist[node.index] + nextNode.cost;
					pq.offer(new Node(nextNode.index,dist[nextNode.index]));
					visited[node.index][nextNode.index] = true;
				}
				
			}
//			for(Node n :pq) {
//				System.out.println(n);
//			}
//			System.out.println("-------------------------------------------");
		}
		
		
		
		
		
	}

	static class Node implements Comparable<Node>{
		int index;
		int cost;
		Node(int index, int cost){
			this.index = index;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
		@Override
		public String toString() {
			return "Node [index=" + index + ", cost=" + cost + "]";
		}
	}
}
