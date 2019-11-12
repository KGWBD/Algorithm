import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Boj1600 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][][] visited;
	static int R, C, K;
	static int[] dx = {0,0,-1,1,2,1,-1,-2,-2,-1,1,2};
	static int[] dy = {-1,1,0,0,1,2,2,1,-1,-2,-2,-1};
	static int ans;
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[K+1][R][C];
		for(int i = 0 ; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0);
		System.out.println(ans==0?-1:ans);
		
	}
	private static void bfs(int y, int x) {
		Queue<Position> q = new LinkedList<>();
		Position pos;
		int ny,nx;
		visited[0][y][x] = true;  //
		q.offer(new Position(y,x,0,0));
		
		while(!q.isEmpty()) {
			pos = q.poll();
			for(int i = 0 ; i < 12; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];
				
				if(!isRange(ny,nx))continue;
				if(pos.num>=K && i>=4)break;
				if(ny==R-1 && nx==C-1) {
					ans = pos.jump+1;
					return;
				}
				if(i<4) {
					if(!visited[pos.num][ny][nx] && map[ny][nx]==0) {
						visited[pos.num][ny][nx] = true;
						q.offer(new Position(ny,nx,pos.jump+1,pos.num));
					}
				} else {
					if(!visited[pos.num+1][ny][nx] && map[ny][nx]==0) {
						visited[pos.num+1][ny][nx] = true;
						q.offer(new Position(ny,nx,pos.jump+1,pos.num+1));
					}
				}
			
			}
		}
		
		
		
		
	}



	private static boolean isRange(int ny, int nx) {
		if(ny<0 || nx<0|| ny>=R || nx>=C)return false;
		return true;
	}

	static class Position {
		int y, x, jump,num;

		public Position(int y, int x, int jump,int num) {
			this.y = y;
			this.x = x;
			this.jump = jump;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + ", jump=" + jump + ", num=" + num + "]";
		}

		
	}

}