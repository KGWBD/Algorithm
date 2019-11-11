import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1249 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static int[][] value;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t= 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			value = new int[N][N];
			
			for(int i = 0 ; i < N ; i++) {
				map[i] = br.readLine().toCharArray();
				Arrays.fill(value[i], INF);
			}
			
			
			bfs(0,0);
			bw.write("#"+t+" ");
			bw.write(value[N-1][N-1] + "\n");
		}
		bw.close();
	}
	private static void bfs(int y, int x) {
		Queue<Position> q = new LinkedList<Problem1249.Position>();
		q.offer(new Position(y,x));
		value[y][x] = 0;
		int ny,nx;
		Position pos;
		while(!q.isEmpty()) {
			pos = q.poll();
			
			for(int i = 0 ; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];
				
				if(!isRange(ny,nx))continue;
				
				if(value[ny][nx] > value[pos.y][pos.x]+ map[ny][nx]-'0') {
					value[ny][nx] = value[pos.y][pos.x]+ map[ny][nx]-'0';
					q.offer(new Position(ny,nx));
				}
			}
		}
		
		
	}
	private static boolean isRange(int ny, int nx) {
		if(ny < 0 || nx < 0 || ny == N || nx == N)return false;
		return true;
	}
	static class Position{
		int y,x;
		Position(int y,int x){
			this.y = y;
			this.x = x;
		}
	}
}