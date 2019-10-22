import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16918 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static int[][] time;
	static int[][] boom;
	static int R,C,N;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Queue<Position> list;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		time = new int[R][C];
		for(int i = 0 ; i < R ; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j]=='O') {
					time[i][j] = 2;
				}
			}
		}	// 폭탄이 있다는 것은 1, 1초 지나면 2, 로 판단하자. 여기서 2로 둔것은 폭탄을 둔후 맨 처음 1초후는 아무것도 안하니 2로

		list = new LinkedList<Boj16918.Position>();
		while(N>1) {
			addTime();
			moveBoomberMan();
			boooom();
			N--;
		}
		
		for(int i = 0 ; i < R; i++) {
			for(int j = 0 ; j < C ;j++) {
				if(time[i][j]>0)bw.write("O");
				else bw.write(".");
			}
			bw.write("\n");
		}
		bw.close();
	}
	
	private static void boooom() {
		int ny,nx;
		Position pos;
		while(!list.isEmpty()) {
			pos = list.poll();
			time[pos.y][pos.x]= 0; 
			for(int i = 0 ; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];
				
				if(!isRange(ny,nx))continue;
				
				time[ny][nx]=0;
			}
			
		}
	}

	private static boolean isRange(int ny, int nx) {
		if(ny<0 || ny==R || nx<0 || nx==C)return false;
		return true;
	}

	private static void addTime() {
		for(int i = 0 ; i < R ;i++) {
			for(int j = 0 ; j < C; j++) {
				time[i][j]++;
				if(time[i][j]==4)list.add(new Position(i,j));
				
			}
		}
		
	}

	private static void moveBoomberMan() {
		for(int i = 0 ; i < R ; i ++) {
			for(int j = 0 ; j < C; j++) {
				if(time[i][j]==0) {
					time[i][j] = 1;
				}
			}
		}
	}
	
	static class Position{
		int y,x;
		Position(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
}
