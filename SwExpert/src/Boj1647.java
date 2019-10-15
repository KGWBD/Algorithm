import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1647 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] p;
	static int N,M;
	static List<Node> list;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		list = new LinkedList<Boj1647.Node>();
		makeSet();
		int now,next,cost;
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			now = Integer.parseInt(st.nextToken());
			next = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			list.add(new Node(now,next,cost));
		}
		Collections.sort(list);
		int cnt = 0;
		int totalCost = 0;
		for(Node n:list) {
			if(union(n)) {		// 마을을 연결한다.
				totalCost += n.cost;
				if(checkCity()) { 	//만약 마을이 2개면 
					break;
				}
			}
		}
		
		
		System.out.println(totalCost);
		
	}
	
	private static boolean checkCity() {
		int cnt = 0;
		for(int i = 1; i<=N; i++) {
			if(p[i]==i)cnt++;
			if(cnt>2)return false;
		}
		
		return true;
	}

	static void makeSet() {
		for(int i = 1; i<=N;i++) {
			p[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(p[x] == x)return x;
		int idx = findSet(p[x]);
		return p[x] = idx;
	}
	
	static boolean union(Node n) {
		int x = findSet(n.now);
		int y = findSet(n.next);
		if(x!=y) {
			p[x] = y;
			return true;
		}
		return false;
	}
	
	static class Node implements Comparable<Node>{
		int now,next,cost;
		Node(int now, int next, int cost){
			this.now = now;
			this.next = next;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node node) {
			return cost - node.cost;
		}
		
	}
}
