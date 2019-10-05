import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1868 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static char[][] map;
	static int[][] count;
	static boolean[][] visited;
	static int N;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	
		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		
		for(int t=1; t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			count = new int[N][N];
			for(int i = 0 ; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int ny,nx;
			ans = 0;
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(map[i][j]=='.') {
						int cnt = 0;
						for(int d = 0; d<8;d++) {
							ny = i + dy[d];
							nx = j + dx[d];
							if(!isRange(ny,nx))continue;
							if(map[ny][nx]=='*')cnt++;
						}
						count[i][j] = cnt;
					} else if(map[i][j]=='*') {
						count[i][j] = -8; //Áö·Ú Ã¼Å©
					}
				}
			}
//			print();
			for(int i = 0; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(!visited[i][j] &&count[i][j]==0) {
						bfs(i,j);
						ans++;
					} 
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(!visited[i][j] &&count[i][j]>0) {
						ans++;
					} 
				}
			}
			bw.write("#"+t + " ");
			bw.write(ans + "\n");
		}	// testCase
		bw.close();
		
	}
	private static void print() {
		for(int i = 0 ; i <N;i++) {
			System.out.println(Arrays.toString(count[i]));
		}
		
	}
	private static void bfs(int y, int x) {
		Queue<Position> q = new LinkedList<Position>();
		q.offer(new Position(y,x));
		visited[y][x] = true;
		int ny,nx;
		while(!q.isEmpty()) {
			Position pos = q.poll();
			
			for(int i = 0 ; i < 8; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];
				
				if(!isRange(ny,nx))continue;
				
				if(!visited[ny][nx]) {
					visited[ny][nx] = true;
					if(count[ny][nx]==0) {
					count[ny][nx] = -1;
					q.offer(new Position(ny,nx));
					}
				}
			}
			
		}
		
	}
		
	private static boolean isRange(int ny, int nx) {
		if(ny<0||ny==N||nx<0||nx==N)return false;
		return true;
	}

	static class Position{
		int y,x;
		Position(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
