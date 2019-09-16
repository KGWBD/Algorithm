import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static Node[][] p;
	static int N,L,R;
	static ArrayList<Node> list;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		p = new Node[N][N];
		makeSet();
		for(int i = 0 ; i < N; i++) {				//경로 다 염
			for(int j = 0 ; j < N ; j++) {
				if(p[i][j].x==i && p[i][j].y==j) {
					list = new ArrayList<>();
					checkPopulation(i,j,map[i][j]);
					System.out.println("=11=1=1=");
				}
			}
		}
		
		System.out.println(map[0][0]);
		
		
	}		
	
	private static void checkPopulation(int y, int x, int popul) {
		//4방향으로 탐색하면서 연합
		
		list.add(new Node(y,x,popul));
		
		
		int ny,nx;
		for(int i=0; i< 4;i++) {
			ny = y+dy[i];
			nx = y+dx[i];
		
			if(!isRange(ny,nx))continue;
			
			if(Math.abs(popul-map[ny][nx])>=L && Math.abs(popul-map[ny][nx])<=R) {
				if(union(p[y][x],p[ny][nx])) {
					checkPopulation(ny, nx, map[ny][nx]);
				}
			}
		}
		int sum = 0;
		for(int i = 0 ; i < list.size();i++) {
			sum += list.get(i).popul;
		}
		for(int i = 0 ; i < list.size();i++) {
			map[list.get(i).y][list.get(i).x] = sum/list.size();
		}
		
	}
	private static boolean isRange(int ny, int nx) {
		if(ny<0||nx<0||ny==N||nx==N)return false;
		return true;
	}

	static void makeSet() {
		for(int i = 0 ; i < N; i++) {
			for(int j=0; j<N;j++) {
				p[i][j] = new Node(i,j);
			}
		}
	}
	
	static Node findSet(int y, int x) {
		if(p[y][x].x==x && p[y][x].y==y)return p[y][x];
		Node n = findSet(p[y][x].y,p[y][x].x);
		p[y][x].x = n.x;
		p[y][x].y = n.y;
		return n;
	}
	
	static boolean union(Node n1, Node n2) {
		Node pn1 = findSet(n1.y,n1.x);
		Node pn2 = findSet(n2.y,n2.x);
		if(pn1.x != pn2.x || pn1.y !=pn2.y) {  //부모가 같지않다면 연합
			pn2.x = pn1.x; 
			pn2.y = pn1.y; 
			return true;
			
		} else {
		}
		return false;
	}
	
	static class Node {
		int y,x,popul;
		Node(int y, int x){
			this.y = y;
			this.x =x;
		}
		Node(int y, int x,int popul){
			this(y,x);
			this.popul = popul;
		}

	}
}
