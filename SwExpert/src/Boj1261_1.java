import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1261_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M;
	static char[][] cMap;
	static int[][] map;
	static boolean[][] visited;
	static int brokenWall = Integer.MAX_VALUE;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cMap = new char[N][M];
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			cMap[i] = br.readLine().toCharArray();
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = cMap[i][j]-'0';
			}
		}
		visited[0][0] = true;
		dfs(0,0,0);
		if(brokenWall==Integer.MAX_VALUE)brokenWall=0;
		bw.write(brokenWall+"\n");
		bw.close();
	}

	private static void dfs(int y, int x, int cnt) {
		if(y==N-1 && x==M-1) {
			if(brokenWall>cnt)brokenWall=cnt;
			return;
		}
		
		if(brokenWall<cnt)return;
		int ny,nx;
		for(int i = 0 ; i < 4; i++) {
			ny = y+dy[i];
			nx = x+dx[i];
			
			if(!isRange(ny,nx))continue;
			
			if(!visited[ny][nx]) {
				visited[ny][nx] = true;
				if(map[ny][nx]==1) {
					dfs(ny,nx,cnt+1);
				} else {
					dfs(ny,nx,cnt);
				}
				visited[ny][nx] = false;
			}
		}
		
	}

	private static boolean isRange(int ny, int nx) {
		if(ny<0 || ny==N || nx<0 || nx==M)return false;
		return true;
	}
}
