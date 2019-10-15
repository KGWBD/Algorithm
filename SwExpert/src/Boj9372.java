import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj9372 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] p;
	static int N,M;
	static List<Node> list;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		list = new LinkedList<Boj9372.Node>();
		makeSet();
		int now,next;
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			now = Integer.parseInt(st.nextToken());
			next = Integer.parseInt(st.nextToken());
			list.add(new Node(now,next));
		}
		int airplane = 0;
		for(Node n:list) {
			if(union(n))airplane++;
		}
		System.out.println(airplane);
		
		}
	
	
	
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
	
	static class Node {
		int now,next,cost;
		Node(int now, int next){
			this.now = now;
			this.next = next;
		}
		
	}
}
