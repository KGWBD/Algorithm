import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj17837 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Horse>[][] horses;
	static Horse[] list;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, K;
	static int ans = -1;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new Horse[K];
		horses = new ArrayList[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				horses[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int y, x, dir;
		Horse horse;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			horse = new Horse(y - 1, x - 1,i, dir - 1);
			horses[y - 1][x - 1].add(horse);
			list[i] = horse;
		}
		outer:while (cnt<1001) {
			cnt++;
			for (int i = 0; i < K; i++) { // 한번 움직일거임
				move(i);
				if(ans!=-1)break outer;
			}
		}
		bw.write(ans+"\n");
		bw.close();

	}

	private static void move(int num) {
		Horse horse = list[num];
		int y, x, dir, ny, nx;
		y = horse.y; // 말의 위치
		x = horse.x;
		dir = horse.dir;
//		System.out.println(" y :: " + y + " x ::" + x + " dir :: " + dir);
		ArrayList<Horse> h = horses[y][x];
		ArrayList<Horse> tempList = new ArrayList<>();
		Horse temp;
		boolean flag = false;

		for (int i = 0; i < h.size(); i++) {
			temp = h.get(i);
			if (temp.num == horse.num) {
//				System.out.println(temp);
				flag = true;
			}

			if (flag) {
				tempList.add(temp);
			}
		}

		ny = y + dy[dir];
		nx = x + dx[dir];

//		System.out.println(" num :: " + num + "ny :: " + ny + " nx :: " + nx);
		if (!isRange(ny, nx) || map[ny][nx] == 2) { // 파란색이거나 범위를 벗어나는 경우
			chageDir(num);
			dir = list[num].dir;
			ny = y + dy[dir];
			nx = x + dx[dir];

			if (isRange(ny, nx) && map[ny][nx] != 2) { // 이동할 수 있는 상태.
				if (map[ny][nx] == 0) {
					horses[ny][nx].addAll(tempList);
					horses[y][x].removeAll(tempList);
					modifyPosition(ny,nx);
				} else if (map[ny][nx] == 1) {
					Collections.reverse(tempList);
					horses[ny][nx].addAll(tempList);
					horses[y][x].removeAll(tempList);
					modifyPosition(ny,nx);
				}
			}
		} else if (map[ny][nx] == 0) {
			horses[ny][nx].addAll(tempList);
			horses[y][x].removeAll(tempList);
			modifyPosition(ny,nx);
		} else if (map[ny][nx] == 1) {
			Collections.reverse(tempList);
			horses[ny][nx].addAll(tempList);
			horses[y][x].removeAll(tempList);
			modifyPosition(ny,nx);
		}

		
		
	}

	private static void modifyPosition(int ny,int nx) {
		ArrayList<Horse> h = horses[ny][nx];
		if(h.size()>=4) {
			ans = cnt;
			return;
		}
			
		for(int i = 0 ; i < h.size(); i++) {
			h.get(i).y = ny;
			h.get(i).x = nx;
		}
		
	}

	private static void chageDir(int num) {
		Horse horse = list[num];
		switch (horse.dir) {
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

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(horses[i][j].size() + " ");
			}
			System.out.println();
		}

	}

	static class Horse {
		int y, x,num, dir;

		Horse(int y, int x,int num, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Horse [y=" + y + ", x=" + x + ", num=" + num + ", dir=" + dir + "]";
		}

	

	}
}
