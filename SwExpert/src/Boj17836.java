import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17836 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R, C, T;
	static boolean[][][] visited;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[2][R][C];
		bfs(0,0);
		System.out.println(ans==Integer.MAX_VALUE?"Fail":ans);
	
	}
	private static void bfs(int y, int x) {
		visited[0][0][0] = true;
		Queue<Position> q = new LinkedList<Boj17836.Position>();
		q.offer(new Position(y,x,0,0));
		int ny,nx;
		Position pos;
		
		while(!q.isEmpty()) {
			pos = q.poll();
			if(pos.cnt>T)return;
			
			for(int i = 0 ; i < 4 ;i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];
				
				if(!isRange(ny,nx))continue;
				if(ny ==R-1 && nx ==C-1) {
					ans = pos.cnt+1;
					return;
				}
				if(pos.status==0) {
					if(!visited[1][ny][nx] && map[ny][nx]==2) {
						visited[1][ny][nx] = true;
						q.offer(new Position(ny,nx,1,pos.cnt+1));
					}
					if(!visited[0][ny][nx] && map[ny][nx]==0) {
						visited[0][ny][nx] = true;
						q.offer(new Position(ny,nx,0,pos.cnt+1));
					}
				} else {
					if(!visited[1][ny][nx]) {
						visited[1][ny][nx] = true;
						q.offer(new Position(ny,nx,1,pos.cnt+1));
					}
				}
				
				
			}
		}
		
		
	}
	private static boolean isRange(int ny, int nx) {
		if(ny<0 || nx<0 || ny==R||nx==C)return false;
		return true;
	}
	static class Position{
		int y,x,status,cnt;
		Position(int y,int x, int status,int cnt){
			this.y =y ;
			this.x = x;
			this.status = status;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + ", status=" + status + "]";
		}
		
	}
}
