import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static ArrayList<Node>[] list;
	static int[] dist;
	static int ans;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine().trim());
		list = new ArrayList[N];
		for(int i = 0; i < N ;i++) {
			list[i] = new ArrayList<>();
		}
		
		dist = new int[N];
		int cost;
		for(int i = 0 ; i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ;j++) {
				cost = Integer.parseInt(st.nextToken()); 
				if(cost!=0) {
					list[i].add(new Node(j,cost));
					
				}
				
			}
		}
		
		Arrays.fill(dist,INF);
		dijstra(0);
		System.out.println(Arrays.toString(dist));
		
	}
	
	
	
	private static void dijstra(int start) {
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,dist[start]));
		Node now,next;
		while(!pq.isEmpty()) {
			now = pq.poll();
			for(int i = 0 ; i < list[now.next].size(); i++) {
				next = list[now.next].get(i);
				
				if(dist[next.next] > dist[now.next] + now.cost) {
					dist[next.next] = dist[now.next] + now.cost;
					pq.add(new Node(next.next,dist[next.next]));
				}
				
			}
			
		}
		
	}



	static class Node implements Comparable<Node>{
		int next,cost;
		Node(int next,int cost){
			this.cost = cost;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
		@Override
		public String toString() {
			return "Node [next=" + next + ", cost=" + cost + "]";
		}
		
	}
}
