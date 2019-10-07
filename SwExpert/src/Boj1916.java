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
	static boolean[] visited;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	static int nV, nE;
	static ArrayList<Node> ansList;
	static int end;
	public static void main(String[] args) throws IOException {
		nV = Integer.parseInt(br.readLine());
		nE = Integer.parseInt(br.readLine());
		visited = new boolean[nV+1];
		list = new ArrayList[nV+1];
		for(int i = 1 ; i <=nV; i++) {
			list[i] = new ArrayList<Boj1916.Node>();
		}
		dist = new int[nV+1];
		Arrays.fill(dist, INF);
		ansList = new ArrayList<Node>();
		for(int i = 0; i<nE; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[now].add(new Node(next,cost, "",0));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijstra(start);
		System.out.println(dist[end]);
		System.out.println(ansList.get(ansList.size()-1).cnt);
		System.out.println(ansList.get(ansList.size()-1).path);
//		System.out.println(Arrays.toString(dist));
	}
		
	private static void dijstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[start] = 0;
		pq.offer(new Node(start,dist[start],"" + start,1));
		Node node;
		while(!pq.isEmpty()) {
			node = pq.poll();
			
			for(int i = 0; i< list[node.index].size();i++) {
				Node nextNode = list[node.index].get(i);
				
				if(dist[nextNode.index] > dist[node.index] + nextNode.cost) {
					dist[nextNode.index] = dist[node.index] + nextNode.cost;
					Node newNode = new Node(nextNode.index,dist[nextNode.index],node.path+" "+nextNode.index,node.cnt+1);
					pq.offer(new Node(nextNode.index,dist[nextNode.index],node.path+" "+nextNode.index,node.cnt+1));
					if(nextNode.index==end) {
						ansList.add(newNode);
					}
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
		String path;
		int cnt;
		Node(int index, int cost,String path,int cnt){
			this.index = index;
			this.cost = cost;
			this.path = path;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
		@Override
		public String toString() {
			return "Node [index=" + index + ", cost=" + cost + ", path=" + path + ", cnt=" + cnt + "]";
		}
		
	}
}
