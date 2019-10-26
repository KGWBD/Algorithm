import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Boj17780 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int N, K;
	static ArrayList<Horse>[][] horseList;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans = -1;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		horseList = new ArrayList[N][N];		// 말을 담을 공간  얹을때 add, 빨간색을 만나면 reverse를 하기위해 ArrayList 배열만듦
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				horseList[i][j] = new ArrayList<Horse>();
			}

		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int y, x, dir;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			horseList[y - 1][x - 1].add(new Horse(i, y - 1, x - 1, dir - 1));
		}
		

		int turn = 0;
		outer:while (turn <= 1000) {
			turn++;
			for (int i = 0; i < K; i++) {
				moveHorse(i);			// 말을 움직인다.
				if(modifyInfo(turn)) {  // 말의 집단이 움직이고 난 후 말들의 위치값을 다 변경해준다. 이 과정에서 말들이 4마리 이상인지 판단한 후 이상이면 turn을 끝낸다.
					break outer;
				}
				
			}
			
			
		}
		bw.write(ans + "\n");
		bw.close();

	}

	private static boolean modifyInfo(int turn) {
		Horse temp;
		for(int i = 0; i < N ; i++) {
			for(int j = 0 ; j <N; j++) {
				if(horseList[i][j].size()>=4) {
					ans = turn;
					return true;
				}
				
				if(horseList[i][j].size()>0) {
					Iterator<Horse> it = horseList[i][j].iterator();
					while(it.hasNext()) {
						temp = it.next();
						temp.y = i;
						temp.x = j;
					}
				}
			}
		}
		return false;
	}

	private static void moveHorse(int num) {
		int ny, nx, y, x, dir;
		Horse horse;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!horseList[i][j].isEmpty()) {
					horse = horseList[i][j].get(0);
					if (horse.num == num) { // 말을 한마리씩 움직일건데 맨 아래에 있는 말이 움직이려는 말이면 움직인다.
						y = horse.y;
						x = horse.x;
						dir = horse.dir;
						
						ny = y + dy[dir];
						nx = x + dx[dir];
						
						if (!isRange(ny, nx) || map[ny][nx] == 2) { // 범위 밖이거나 파란색이면..
							changeDir(horse);		//방향을 전환해주고 움직일 준비를 한다.
							dir = horse.dir;
							ny = y + dy[dir];
							nx = x + dx[dir];
							if (isRange(ny,nx) && map[ny][nx] != 2) { // 움직이려는 곳이 파란색이 아니고 범위안 일 때
								if(map[ny][nx]==1) {		// 빨간색이면 다시 뒤집어준다
									Collections.reverse(horseList[i][j]);
								}
								horseList[ny][nx].addAll(horseList[i][j]); 
								horseList[i][j].clear();
							}
						} else if(map[ny][nx]==0) {
							horseList[ny][nx].addAll(horseList[i][j]);
							horseList[i][j].clear();
							
						} else if(map[ny][nx]==1){
							Collections.reverse(horseList[i][j]);
							horseList[ny][nx].addAll(horseList[i][j]); // 덮어쓴다.
							horseList[i][j].clear();
						}
						return;
					}
				}

			}
		}
	}

	private static void changeDir(Horse horse) {
		int dir = horse.dir;

		switch (dir) {
		case 0:
			horse.dir = 1;
			break;
		case 1:
			horse.dir = 0;
			break;
		case 2:
			horse.dir = 3;
			break;
		case 3:
			horse.dir = 2;
			break;

		}

	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == N)
			return false;
		return true;
	}

	static class Horse {
		int num, y, x, dir;

		Horse(int num, int y, int x, int dir) {
			this.num = num;
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Horse [y=" + y + ", x=" + x + ", dir=" + dir + "]";
		}

	}

}
