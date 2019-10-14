import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1717 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		makeSet();
		int btn,n1,n2;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			btn = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			if(btn==0) {
				union(n1,n2);
			}else {
				n1 = findSet(n1);
				n2 = findSet(n2);
				if(n1==n2) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		
		
		
	}
	
	static void makeSet() {
		for(int i = 1; i <=N; i++) {
			p[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(p[x] == x)return x;
		int idx = findSet(p[x]);
		return p[x] = idx;
	}
	
	static boolean union(int x,int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px!=py) {
			p[px] = py;
			return true;
		}
		return false;
	}
	
}
