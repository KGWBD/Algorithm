import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1261 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M;
	static char[][] cMap;
	static int[][] map;
	static int[][] valueArr;
	static int brokenWall = Integer.MAX_VALUE;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cMap = new char[N][M];
		map = new int[N][M];
		valueArr = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			cMap[i] = br.readLine().toCharArray();
		}
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(valueArr[i], INF);
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.valueOf(cMap[i][j]-'0');
			}
		}
		

		bfs(0,0);
		if(brokenWall==Integer.MAX_VALUE)brokenWall=0;
		bw.write(valueArr[N-1][M-1]+"\n");
		bw.close();
	}

	
	private static void bfs(int y, int x) {
		Queue<Position> q= new LinkedList<>();
		q.offer(new Position(0,0));
		valueArr[0][0] = 0;
		int ny,nx;
		Position pos;
		while(!q.isEmpty()) {
			pos = q.poll();
			
			for(int i = 0 ; i<4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];
				
				if(!isRange(ny, nx))continue;
				
				if(valueArr[ny][nx] > valueArr[pos.y][pos.x] + map[ny][nx]) {
					valueArr[ny][nx] = valueArr[pos.y][pos.x] + map[ny][nx];
					q.offer(new Position(ny,nx));
				}
			}
		}
		
	}




	private static boolean isRange(int ny, int nx) {
		if(ny<0 || ny==N || nx<0 || nx==M)return false;
		return true;
	}
	static class Position{
		int y,x,cnt;
		Position(int y, int x){
			this.y = y;
			this.x = x;
		}
		
	}
}
