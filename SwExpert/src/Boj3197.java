import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//�� ó�� ��� -> 1. bfs�� ���� ������ ���ϸ� �����ϰ� ���߿� �ѹ��� ���δ�.
//               2. �������� bfs�� ���� �� �ִ��� Ȯ���Ѵ�.
//               3. ���� �� ������ 1�� 2�� �ݺ��Ѵ�
//               -> �ð��ʰ� ::  R�� C�� ����� �ִ� 1500�̰� �Ź� �ݺ��ϱ⿡
//                              ���ʿ��ϰ� �ߺ����� �κ��� �ٿ���� �ߴ�.

//�ι�° ��� ->  1. ���ϸ� ���϶� ��� ������ bfs�� �������� ���� ���� ���Ϻ��� ����
//                  ���ϸ� ã�Ƽ� �����ϰ� ���߿� �ѹ��� ���δ�.
//               2. ó������ ����
//               -> �ð��ʰ� :: �ſ� ������ �ð��� �ٿ��� �ذ�å�� �ƴϿ���.


//����° (����) -> 1. ó�� ������� 1,2���� ��� �ݺ��ϴ� ���� �ƴ϶�
//                bfs �� ������ ��� ���ϸ� ���̰� ��¥�� �����س��´�. -> ���ʿ��� �ݺ� ����
//                2. ������ ������ �ϴµ� �켱����ť�� ����ؼ� ���� ���� ��¥�� ����. 

//�˰Ե� ��:: 1. ����ġ�� �ִܰŸ��� �ƴ� �ٸ� ����� ��� �켱����ť�� ������ �� �־���� �� ����.
//           2. �ܼ��ϰ� �� �� ���̰� ã�� ���̰� ã�� �ܼ��ݺ����� �� ���� ó���ϰ� �ٸ� 
//           �迭�� ����� ������ �� ã�Ƴ��� ����� �ִٴ� ���� �˰ԵǾ���.

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
		}//�Է�
		
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