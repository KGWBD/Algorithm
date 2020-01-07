import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//맨 처음 사고 -> 1. bfs로 물과 인접한 빙하를 저장하고 나중에 한번에 녹인다.
//               2. 백조들을 bfs로 만날 수 있는지 확인한다.
//               3. 만날 수 없으면 1과 2를 반복한다
//               -> 시간초과 ::  R과 C의 사이즈가 최대 1500이고 매번 반복하기에
//                              불필요하고 중복적인 부분을 줄여줘야 했다.

//두번째 사고 ->  1. 빙하를 녹일때 모든 물에서 bfs를 시작하지 말고 녹인 빙하부터 녹일
//                  빙하를 찾아서 저장하고 나중에 한번에 녹인다.
//               2. 처음사고와 같음
//               -> 시간초과 :: 매우 조금의 시간을 줄였지 해결책이 아니였다.


//세번째 (찬스) -> 1. 처음 사고에서의 1,2번을 계속 반복하는 것이 아니라
//                bfs 한 번으로 모든 빙하를 녹이고 날짜를 저장해놓는다. -> 불필요한 반복 제거
//                2. 백조를 만나게 하는데 우선순위큐를 사용해서 가장 적은 날짜를 고른다. 

//알게된 점:: 1. 가중치가 최단거리가 아닌 다른 비용인 경우 우선순위큐를 생각할 수 있어야할 것 같다.
//           2. 단순하게 한 번 녹이고 찾고 녹이고 찾고 단순반복보다 한 번에 처리하고 다른 
//           배열에 비용을 저장한 후 찾아내는 방법도 있다는 것을 알게되었다.

public class Boj3197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int R, C;
	static int[][] water;
	static int startY, startX,endY,endX,ans;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		water = new int[R][C];
		
		boolean flag = false;
		for(int i = 0 ; i < R ; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < C ;j++) {
				if(map[i][j] == 'L') {
					if(!flag) {
						startY = i;
						startX = j;
						flag = true;
					} else {
						endY = i;
						endX = j;
					}
					map[i][j] ='.';
				}
			}
		}//입력
		
		melt();
		meet();
		System.out.println(ans);
	}
	
	private static void meet() {
		PriorityQueue<Position> pq = new PriorityQueue<Boj3197.Position>();
		boolean[][] visited = new boolean[R][C];
		pq.offer(new Position(startY,startX,0));
		visited[startY][startX] = true;
		
		Position pos;
		int ny,nx;
		
		while(!pq.isEmpty()) {
			pos = pq.poll();
			
			for(int i = 0 ; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];
				
				if(!isRange(ny,nx)||visited[ny][nx])continue;
				
				if(ny == endY && nx == endX) {
					ans = pos.day;
					return;
				}
				visited[ny][nx] = true;
				pq.offer(new Position(ny,nx,Math.max(water[ny][nx], pos.day)));
			}
			
		}
		
	}
	private static void melt() {
		boolean[][] visited = new boolean[R][C];
		Queue<Position> q = new LinkedList<Boj3197.Position>();
		
		for(int i = 0 ; i < R; i++) {
			for(int j = 0 ; j < C; j++) {
				if(map[i][j]=='.') {
					visited[i][j] = true;
					q.offer(new Position(i,j,0));
				}
			}
		}
		
		Position pos;
		int ny,nx,size,day = 0;
		while(!q.isEmpty()) {
			size = q.size();
			
			for(int i = 0 ; i < size; i++) {
				pos = q.poll();
				water[pos.y][pos.x] = day;
				
				for(int d = 0 ; d < 4 ;d++) {
					ny = pos.y + dy[d];
					nx = pos.x + dx[d];
					if(!isRange(ny,nx) || visited[ny][nx])continue;
					
					visited[ny][nx] = true;
					q.offer(new Position(ny,nx,0));
				}
			}
			day++;
		}
	}
	private static boolean isRange(int ny, int nx) {
		if(ny<0 || nx<0 || ny==R || nx==C)return false;
		return true;
	}
	static class Position implements Comparable<Position>{
		int y,x,day;
		Position(int y,int x,int day){
			this.y = y;
			this.x = x;
			this.day = day;
		}
		@Override
		public int compareTo(Position o) {
			return this.day - o.day;
		}
		
		
		
	}
}