import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1,1,0,0 };
	static int N;
	static boolean[][] visited;
	static Queue<Shark> sharkList;
	static int maxTime = 0;
	static int sharkCnt = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		sharkList = new LinkedList<Boj16236.Shark>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				if (val == 9) {
					sharkList.add(new Shark(i, j, 2, 0, 0));
					map[i][j] = 0;
				}
					
				else if (val != 9 && val != 0)
					sharkCnt++;
			}
		}
		if (sharkCnt != 0) {
			moveShark();
		}
		
		System.out.println(maxTime);
	}

	private static void moveShark() {
		Shark shark = sharkList.peek();
		visited[shark.y][shark.x] = true;
		PriorityQueue<Shark> tempList = new PriorityQueue<Boj16236.Shark>();
		int ny, nx;
		int is = 0;
		while (sharkCnt>0) {
			int time = Integer.MAX_VALUE;
			tempList.clear();
			
			while (!sharkList.isEmpty()) {
				shark = sharkList.poll();
				if(time<shark.time)break;
				for (int i = 0; i < 4; i++) {
					ny = shark.y + dy[i];
					nx = shark.x + dx[i];

					if (!isRange(ny, nx) || map[ny][nx] > shark.size)
						continue;// 범위 밖이거나 상어 크기보다 큰 고기면 패스;;

					if (!visited[ny][nx] && map[ny][nx]!=0 && map[ny][nx] < shark.size) { //아기상어가 잡아먹을수 있는 것들
						visited[ny][nx] = true;
						tempList.add(new Shark(ny,nx,shark.size,shark.eat,shark.time+1));
						time = shark.time;
					}
					if (!visited[ny][nx] && (map[ny][nx] == 0 || map[ny][nx]==shark.size)) {
						visited[ny][nx] = true;
						sharkList.add(new Shark(ny, nx, shark.size, shark.eat, shark.time + 1));
					}
				}
			} // while
			
			if(tempList.size()!=0) {
				sharkList.clear();
//				for(Shark s:tempList) {
//					System.out.println(s);
//				}
//				System.out.println("======================");
				shark = tempList.poll();
//				System.out.println(shark);
				if(shark.eat+1==shark.size) {
					sharkList.add(new Shark(shark.y,shark.x,shark.size+1,0,shark.time));
				} else {
					sharkList.add(new Shark(shark.y,shark.x,shark.size,shark.eat+1,shark.time));
				}
				maxTime=shark.time;
				map[shark.y][shark.x] = 0;
				visited = new boolean[N][N];
				visited[shark.y][shark.x] = true;
				sharkCnt--;
			} else {
				return;
			}
			
			
		}

	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == N)
			return false;
		return true;
	}

	static class Shark implements Comparable<Shark> {
		int y, x, size, eat, time;

		Shark(int y, int x, int size, int eat, int time) {
			this.y = y;
			this.x = x;
			this.size = size;
			this.eat = eat;
			this.time = time;
		}

		@Override
		public int compareTo(Shark o) {
				if (y == o.y) {
					return x - o.x;
				} else {
					return y - o.y;
				}
		}

		@Override
		public String toString() {
			return "Shark [y=" + y + ", x=" + x + ", size=" + size + ", eat=" + eat + ", time=" + time + "]";
		}
	}
}