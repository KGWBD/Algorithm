import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1194{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][][] visited;
	static int N, M;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int startX =0, startY = 0;
		for(int i = 0 ; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0 ; j < M; j++) {
				if(map[i][j]=='0') {
					startY = i;
					startX = j;
					map[i][j] = '.';			// 시작점도 빈 곳이기 때문에 .으로 바꿔준다.
				}
			}
		} // 입력 받는 곳..
		visited = new boolean[22][N][M]; //키를 가지는 것을 중복체크하기위해서,
			//a는 1 b는 2, c는 3, d는 4, e는 5, f는 6,     ab키를 가지면 3,   af키를 가지면 7 모두 다 가지면 21이라는 숫자를 가지고 이를 통해 체크.
		
		bfs(startY,startX);
		
		if(ans==Integer.MAX_VALUE)ans=-1;
		bw.write(ans+"\n");
		bw.close();
		
	}
	
	private static void bfs(int y, int x) {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(y,x,"",0,0));
		visited[0][y][x] = true;
		int ny,nx;
		Position pos;
		while(!q.isEmpty()) {
			pos = q.poll();
			for(int i = 0 ; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];
				
				if(!isRange(ny,nx))continue;
				
				if(!visited[pos.keyNum][ny][nx]) {//일단 방문안했을 때
					if(map[ny][nx]=='.') {	// '.'온점이면 카운트만 증가한 채 큐에 넣어줌
						visited[pos.keyNum][ny][nx] =true;
						q.offer(new Position(ny, nx, pos.keys, pos.keyNum, pos.cnt+1));
					} else if(map[ny][nx]<='f' && map[ny][nx]>='a') { //칸이 열쇠일 때 가지고 있는 열쇠인지, 안 가지고 있는 열쇠인지 판단 후  
						if(pos.keys.indexOf(String.valueOf(map[ny][nx]).toUpperCase())==-1) { //안  가지고 있는 열쇠니깐 추가해준다.
							visited[pos.keyNum+(map[ny][nx]-'a')+1][ny][nx] = true;
							q.offer(new Position(ny, nx, pos.keys+String.valueOf(map[ny][nx]).toUpperCase(), pos.keyNum+(map[ny][nx]-'a')+1, pos.cnt+1));	
						}else {		//가지고 있는 열쇠면 그냥 넘어간다.
							visited[pos.keyNum][ny][nx] = true;
							q.offer(new Position(ny, nx, pos.keys, pos.keyNum, pos.cnt+1));
						}
					} else if(map[ny][nx]<='F' && map[ny][nx]>='A') { //문이면
						if(pos.keys.indexOf(map[ny][nx])!=-1) {	//키가 있으면 지나갈 수 있다.
							visited[pos.keyNum][ny][nx] = true;
							q.offer(new Position(ny,nx,pos.keys,pos.keyNum,pos.cnt+1));
						}
					} else if(map[ny][nx]=='1') {
						if(ans>pos.cnt+1)ans=pos.cnt+1;
						return;
					}
					
					
					
					
				}
				
				
				
				
			}
			
			
			
		}
		
		
	}

	private static boolean isRange(int ny, int nx) {
		if(ny < 0 || ny == N || nx < 0 || nx ==M)return false;
		return true;
	}

	static class Position {
		int y,x,keyNum,cnt;
		String keys; //키를 대문자로 저장
		Position(int y, int x, String keys,int keyNum, int cnt){
			this.y = y;
			this.x = x;
			this.keys = keys.toUpperCase();
			this.keyNum = keyNum;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Position [y=" + y + ", x=" + x + ", keyNum=" + keyNum + ", cnt=" + cnt + ", keys=" + keys + "]";
		}
		
	}
}