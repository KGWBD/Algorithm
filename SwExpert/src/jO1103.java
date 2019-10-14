import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jO1103 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R,C,M;
	static int[] dist;
	static int[][] map;
	static boolean[][] visited;
	static int store;
	static int[][] directions = {
			{-1,0},{0,1},{1,0},{0,-1}
	};
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		M =  Integer.parseInt(br.readLine());
		map = new int[R+1][C+1];
		dist = new int[M+1]; //상점개수와 나를 더한 크기만큼 배열.
		
		int dir,dis;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			dis = Integer.parseInt(st.nextToken());
			buildStore(dir,dis,i+1);
		}

		st = new StringTokenizer(br.readLine());
		dir = Integer.parseInt(st.nextToken());
		dis = Integer.parseInt(st.nextToken());
		buildStore(dir,dis,-1); //나자신의 위치
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		store = M;
		visited = new boolean[R+1][C+1];
		goToStore(dir,dis,1);
		store = M;
		visited = new boolean[R+1][C+1];
		goToStore(dir,dis,0);
		
		int ans = 0;
		
		for(int n:dist) {
			ans+=n;
		}
		System.out.println(ans);
		
		
	}
	private static void goToStore(int dir, int dis,int cas) {
		int ny,nx,direction,totalDis;
		ny = nx = direction = totalDis = 0;
		
		if(cas==1) { // 시계방향;
			switch(dir) {
			case 1:
				ny = 0; nx = dis;
				direction = 1;
				break;
			case 2:
				ny=R;nx=dis;
				direction = 3;
				break;
			case 3:
				nx=0;ny=dis;
				direction = 0;
				break;
			case 4:
				nx=C;ny=dis;
				direction = 2;
				break;
			}
			while(store>0) {
				ny += directions[direction][0];
				nx += directions[direction][1];
				
				if(!isRange(ny,nx)) {
					ny -= directions[direction][0];
					nx -= directions[direction][1];
					direction = changeDirection(direction,1);
					ny += directions[direction][0];
					nx += directions[direction][1];
				}
				if(map[ny][nx]==-1)return;
				totalDis++;
				if(!visited[ny][nx] && map[ny][nx]==0) {
					visited[ny][nx] = true;
					continue;
				}
				if(!visited[ny][nx] && map[ny][nx]>0) {
					visited[ny][nx] = true;
					store--;
					if(dist[map[ny][nx]] > totalDis) {
						dist[map[ny][nx]] = totalDis;
					}
				}
				
				
			}
		} else { // 반시계
			switch(dir) {
			case 1:
				ny = 0; nx = dis;
				direction = 3;
				break;
			case 2:
				ny=R;nx=dis;
				direction = 1;
				break;
			case 3:
				nx=0;ny=dis;
				direction = 2;
				break;
			case 4:
				nx=C;ny=dis;
				direction = 0;
				break;
			}
			while(store>0) {
				ny += directions[direction][0];
				nx += directions[direction][1];
				
				if(!isRange(ny,nx)) {
					ny -= directions[direction][0];
					nx -= directions[direction][1];
					direction = changeDirection(direction,0);
					ny += directions[direction][0];
					nx += directions[direction][1];
				}
				if(map[ny][nx]==-1)return;
				totalDis++;
				if(!visited[ny][nx] && map[ny][nx]==0) {
					visited[ny][nx] = true;
					continue;
				}
				if(!visited[ny][nx] && map[ny][nx]>0) {
					visited[ny][nx] = true;
					store--;
					if(dist[map[ny][nx]] > totalDis) {
						dist[map[ny][nx]] = totalDis;
					}
				}
				
				
			}
		}
		
		
	}
	private static int changeDirection(int direction, int i) {
		if(i==1) {
			return (direction+1)%4;
		} else {
			if(direction==0) {
				return 3;
			}
			else {
				return direction-1;
			}
		}
		
	}
	private static boolean isRange(int ny, int nx) {
		if(ny<0|| ny==R+1 || nx<0 || nx==C+1)return false;
		return true;
	}
	private static void buildStore(int dir, int dis,int n) {
		switch(dir) {
		case 1:
			map[0][dis] = n;
			break;
		case 2:
			map[R][dis] = n;
			break;
		case 3:
			map[dis][0] = n;
			break;
		case 4:
			map[dis][C] = n;
			break;
		}
	}
}
