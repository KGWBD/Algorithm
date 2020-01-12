import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2665 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static int[][] brokenWall;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N,ans;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		brokenWall = new int[N][N];
		map = new char[N][N];
		for(int i = 0 ; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(brokenWall[i], Integer.MAX_VALUE);
		}
		
		solve();
		
		bw.write(ans+"\n");
		bw.close();
	}
	private static void solve() {
		PriorityQueue<Position> pq = new PriorityQueue<Boj2665.Position>();
		pq.offer(new Position(0,0,0));
		brokenWall[0][0] = 0;
		int ny,nx;
		Position now;
		while(!pq.isEmpty()) {
			now = pq.poll();
			for(int i = 0 ; i < 4; i++) {
				ny = now.y + dy[i];
				nx = now.x + dx[i];
				
				if(!isRange(ny,nx))continue;
				if(ny==N-1 && nx==N-1) {
					ans = now.cnt;
					return;
				}
				if(map[ny][nx]=='1') {  //빈 방일때
					if(now.cnt<brokenWall[ny][nx]) { //지금까지 거친 검은 방의 수보다 작으면 들어간다.
						brokenWall[ny][nx] = now.cnt;
						pq.offer(new Position(ny,nx,now.cnt));
					}
				} else {
					if(now.cnt+1<brokenWall[ny][nx]) {
						brokenWall[ny][nx] = now.cnt+1;
						pq.offer(new Position(ny,nx,now.cnt+1));
					}
				}
			}
		}
		
		
	}
	
	private static boolean isRange(int ny, int nx) {
		if(ny<0 || nx<0 ||ny==N || nx==N)return false;
		return true;
	}

	static class Position implements Comparable<Position>{
		int y,x,cnt;
		Position(int y,int x,int cnt){
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Position p) {
			return this.cnt - p.cnt;
		}
		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}
		
		
	}
}
