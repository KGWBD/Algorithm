import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17070 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int[] dx = {1,1,0};
	static int[] dy = {0,1,1};
	static int N;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		long start = System.currentTimeMillis();
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,1,0);
		System.out.println(ans);
		System.out.println(System.currentTimeMillis()-start);
	}

	private static void dfs(int y, int x, int dir) {
		if(y==N-1 && x==N-1) {
			ans++;
			return;
		}
		
		int ny,nx;
		
		for(int i = 0; i < 3; i++) {
			if(dir==0 && i==2)continue;
			if(dir==2 && i==0)continue;
			
			ny = y + dy[i];
			nx = x + dx[i];
			
			if(!isRange(ny, nx))continue;
			
			if(i==1) {
				if(map[ny-1][nx]==0 && map[ny][nx-1]==0 && map[ny][nx]==0) {
					dfs(ny,nx,i);
				}
			} else {
				if(map[ny][nx]==0) {
					dfs(ny,nx,i);
				}
			}
				
			
		}
	}
	static boolean isRange(int ny,int nx) {
		if(ny<0 || ny==N || nx<0 ||nx==N)return false;
		return true;
	}
}
