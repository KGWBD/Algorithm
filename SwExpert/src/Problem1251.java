import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem1251 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<Node> list;
	static StringTokenizer st;
	static int N;
	static double E;
	static int[] p;
	static Node[] vertex;
    public static void main(String[] args) throws NumberFormatException, IOException {   
    	
    	int tc = Integer.parseInt(br.readLine());
//    	int tc = 1;
    	for(int t = 1; t<=tc;t++) {
    		list = new LinkedList<Problem1251.Node>();
    		N = Integer.parseInt(br.readLine());
    		st = new StringTokenizer(br.readLine());
    		int[] xArr = new int[N];
    		p = new int[N+1];
    		for(int i = 0; i < N;i++) {
    			xArr[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		st = new StringTokenizer(br.readLine());
    		int[] yArr = new int[N];    		
    		for(int i = 0; i < N;i++) {
    			yArr[i] = Integer.parseInt(st.nextToken());
    		}
    		E = Double.parseDouble(br.readLine());
    		vertex = new Node[N+1];
    		for(int i = 0; i<N;i++ ) {
    			vertex[i+1] = new Node(xArr[i],yArr[i]);
    		}
    		
    		for(int i = 1; i<=N-1; i++) {
    			for(int j=i+1;j<=N;j++) {
    				setInfo(i,j);
    			}
    		}
    		makeSet();
    		Collections.sort(list);
    		Iterator<Node> it = list.iterator();
    		long totalDis = 0L;
    		while(it.hasNext()) {
    			Node node = it.next();
    			if(union(node)) {
    				totalDis += node.dis;
    			}
    		}
    		
    		long ans = Math.round(totalDis*E);
    		System.out.format("#%d %d\n",t,ans);
    		
    		
    	} //testCase
    	
    	
    }
    private static void makeSet() {
    	for(int i = 1; i<=N;i++) {
    		p[i] = i;
    	}
	}
    private static int findSet(int x) {
    	if(p[x] == x)return x;
    	int idx = findSet(p[x]);
    	return idx;
    }
    private static boolean union(Node n) {
    	int px = findSet(n.now);
    	int py = findSet(n.next);
    	if(px!=py) {
    		p[px]=py;
    		return true;
    	}
    	return false;
    }
	private static void setInfo(int i, int j) {
    	int x1,x2,y1,y2;
    	Node now = vertex[i];
    	Node next = vertex[j];
    	x1 = now.x;
    	y1 = now.y;
    	x2 = next.x;
    	y2 = next.y;
    	
    	long dis = (long)Math.pow(x2-x1, 2) + (long)Math.pow(y2-y1, 2);
    	list.add(new Node(i,j,dis));
    }
	static class Node implements Comparable<Node>{
    	int x,y;
    	int now,next;
    	long dis;
    	Node(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    	Node(int now, int next, long dis){
    		this.now = now;
    		this.next = next;
    		this.dis = dis;
    	}
		@Override
		public int compareTo(Node o) {
			return new Long(dis).compareTo(new Long(o.dis));
		}
    	
    	
    }
}