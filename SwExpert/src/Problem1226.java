import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1226 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N = 16;
	static int ans;
	public static void main(String[] args) throws IOException {
		int T = 10;
		for(int t =1 ; t<= T; t++) {
			br.readLine();
			map = new char[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0 ; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			ans = 0;
			bfs();
			
			bw.write("#" + t + " ");
			bw.write(ans + "\n");
		}//testCAse
		bw.close();
	}

	private static void bfs() {
		Queue<Position> q = new LinkedList<Position>();
		q.offer(new Position(13,13));
		int ny,nx;
		visited[13][13] = true;
		while(!q.isEmpty()) {
			Position pos = q.poll();
			if(pos.x==1 && pos.y==1) {
				ans = 1;
				return;
			}
			for(int i = 0 ; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];
				
				if(!isRange(ny,nx))continue;
				
				if(!visited[ny][nx] && (map[ny][nx]=='0'|| map[ny][nx]=='2')) {
					visited[ny][nx] = true;
					q.offer(new Position(ny,nx));
				}
				
			}
			
			
			
		}
		
	}
	static boolean isRange(int ny,int nx) {
		if(ny<0 || ny==N || nx<0 || nx==N)return false;
		return true;
	}
	static class Position{
		int y,x;
		Position(int y, int x){
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + "]";
		}
		
	}
}
