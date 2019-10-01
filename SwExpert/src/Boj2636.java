
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2636 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N,M;
	static int cheese;
	
	public static void main(String[] args) throws IOException {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			int tmp;
			for(int i = 0 ;i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < M; j++) {
					tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;
					if(tmp==1)cheese++;
				}
			}
			int time=0;
			int tempCheese = 0;
			while(cheese>0) {
				tempCheese = cheese;
				time++;
				dfs(0,0);
				removeCheese();
			}
			System.out.println(time);
			System.out.println(tempCheese);
	}
	private static void removeCheese() {
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < M;j++) {
				if(map[i][j]==2) {
					map[i][j]=0;
				}
			}
		}
	}
	private static void dfs(int y, int x) {
		boolean[][] visited = new boolean[N][M];
		visited[y][x] =true;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(y,x));
		int ny,nx;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(map[p.y][p.x]==1) {
				cheese--;
				map[p.y][p.x] =2;
				continue;
			}
			for(int i = 0 ; i < 4; i++) {
				ny = p.y + dy[i];
				nx = p.x + dx[i];
				
				if(!isRange(ny,nx))continue;
				
				if(!visited[ny][nx] && map[ny][nx]!=2) {
					visited[ny][nx] = true;
					q.offer(new Pair(ny,nx));
				}
			}
			
			
		}
		
		
	}
	private static boolean isRange(int ny, int nx) {
		if(ny<0||ny==N||nx<0||nx==M)return false;
		return true;
	}
	static class Pair{
		int y,x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
}// end class