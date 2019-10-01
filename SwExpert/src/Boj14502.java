import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static LinkedList<Pair> list;
	static int row, col;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		
		list = new LinkedList<Boj14502.Pair>();
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 2) {
					list.add(new Pair(i, j));
				}
			}
		}

		dfs(0, 0, 0);
		System.out.println(max);
	}

	private static void dfs(int i, int j, int cnt) {
		if (cnt == 3) {
				virus();	
				return;    //벽이 3개 일 때 바이러스를 퍼트리자
		}
		
		for (int y = 0; y < row; y++) {
			for (int x = 0; x < col; x++) {
				if (map[y][x] == 0) {
					map[y][x] = 1;
					dfs(y, x, cnt + 1);
					map[y][x] = 0;
				}

			}
		}

	}

	private static void virus() {
		int[][] newMap = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		for(Pair p:list) {
			diffusion(newMap,p.y,p.x);
		}
		
		int cnt = 0;
		for(int i = 0 ; i < row; i++) {
			for(int j = 0; j<col; j++) {
				if(newMap[i][j]==0)cnt++;
			}
		}
		if(max<cnt)max = cnt;
		
	}

	private static void diffusion(int[][] newMap, int y, int x) {
		
		int ty,tx;
		
		for(int i = 0 ; i < 4; i++) {
			ty = y+ dy[i];
			tx = x+ dx[i];
			
			if(ty<0 || ty==row || tx<0 || tx==col) {
				continue;
			}
			if(newMap[ty][tx]==0) {
				newMap[ty][tx]=2;
				diffusion(newMap,ty,tx);
			}
			
			
		}
		
	}

	static class Pair {
		int x;
		int y;

		Pair(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

}
