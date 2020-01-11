import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4179 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] map;
	static boolean[][][] visited;
	static int[][] time;
	static int N, M,startX,startY;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Queue<Position> fireList = new LinkedList<Boj4179.Position>();
	static int ans;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[2][N][M];
		time = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0 ; j < M; j++) {
				if(map[i][j] == 'J') {
					map[i][j] = '.';
					startY = i;
					startX = j;
				} else if(map[i][j] == 'F') {
					fireList.add(new Position(i,j,0));
					visited[0][i][j] = true;
				}
			}
		}
		
		solve();
		if(ans==0) {
			bw.write("IMPOSSIBLE\n");
		} else {
			bw.write(ans+"\n");
		}
		bw.close();
	}
	private static void solve() {
		spreadFire();
//		printTime();
		move();
	}
	private static void move() {
		Queue<Position> q= new LinkedList<Boj4179.Position>();
		visited[1][startY][startX] = true;
		q.offer(new Position(startY,startX,0));
		Position person;
		int ny,nx;
		while(!q.isEmpty()) {
			person = q.poll();
//			System.out.println(person);
			for(int i = 0 ; i < 4; i++) {
				ny = person.y + dy[i];
				nx = person.x + dx[i];
				
				if(ny<0 || nx<0 || ny==N || nx==M) {
					ans = person.hour + 1;
					return;
				}
				if(visited[1][ny][nx])continue;
				if(map[ny][nx]=='F' || map[ny][nx]=='#')continue;
				
				if(time[ny][nx]==0 || person.hour+1<time[ny][nx]) {
					visited[1][ny][nx] = true;
					q.offer(new Position(ny,nx,person.hour+1));
					
				}
				
			}
		}
	}
	private static boolean canEscape(int ny, int nx) {
		if(ny ==0 || nx==0 || ny==N-1 || nx==M-1)return true;
		return false;
	}
	private static boolean isRange(int ny, int nx) {
		if(ny<0 || nx<0 || ny==N || nx==M)return false;
		return true;
	}
	private static void prinTtime() {
		for(int i = 0 ; i < N ;i++) {
			System.out.println(Arrays.toString(time[i]));
		}
	}
	private static void spreadFire() {
		int ny,nx;
		Position fire;
		while(!fireList.isEmpty()) {
			fire = fireList.poll();
			
			for(int i = 0 ; i < 4; i++) {
				ny = fire.y + dy[i];
				nx = fire.x + dx[i];
				if(!isRange(ny,nx) || visited[0][ny][nx])continue;
				if(map[ny][nx]!='.')continue;
				
				visited[0][ny][nx] = true;
				time[ny][nx] = fire.hour+1;
				fireList.add(new Position(ny,nx,fire.hour+1));
			}
		}
		
		
	}
	
	static class Position{
		int y, x, hour;
		Position(int y,int x,int hour){
			this.y =y ;
			this.x = x;
			this.hour = hour;
		}
		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + ", hour=" + hour + "]";
		}
		
		
	}
}
