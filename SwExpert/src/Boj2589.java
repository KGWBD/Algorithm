import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2589 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static int N,M;
	static final int INF = Integer.MAX_VALUE;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M; j++) {
				if(map[i][j]=='L') {
					solve(i,j);
				}
			}
		}
		System.out.println(ans);
		
	}
	private static void solve(int y, int x) {
		Queue<Position> q = new LinkedList<Boj2589.Position>();
		int[][] valueArr = new int[N][M];
		fillArr(valueArr);	//
		q.offer(new Position(y,x,0));
		int ny,nx;
		int minDis = 0;
		valueArr[y][x] = 0;
		Position pos;
		while(!q.isEmpty()) {
			pos = q.poll();
			if(minDis<pos.dis)minDis=pos.dis;
			for(int i = 0 ; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];
				if(!isRange(ny,nx))continue;
				
				if(map[ny][nx]=='L' && valueArr[ny][nx]> valueArr[pos.y][pos.x]+1) {
					valueArr[ny][nx] = valueArr[pos.y][pos.x]+1;
					q.offer(new Position(ny,nx,pos.dis+1));
					
				}
			}
		}
		
		if(minDis>ans)ans=minDis;
		
		
		
	}
	private static boolean isRange(int ny, int nx) {
		if(ny<0 || ny==N || nx<0 || nx==M)return false;
		return true;
	}
	private static void fillArr(int[][] valueArr) {
		for(int i = 0 ; i < N; i++) {
			Arrays.fill(valueArr[i], INF);
		}
	}
	static class Position{
		int y,x,dis;
		Position(int y, int x,int dis){
			this.y = y;
			this.x = x;
			this.dis = dis;
		}
		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + ", dis=" + dis + "]";
		}
		
	}
	
}
