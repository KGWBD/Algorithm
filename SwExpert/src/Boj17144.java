import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj17144 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R, C, T;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		ArrayList<Machine> list = new ArrayList<Boj17144.Machine>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num==-1) {
					list.add(new Machine(i,j));
				}
			}
		} // 초기 상태 입력...
		while (T > 0) {
			int[][] tempMap = new int[R][C];
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == -1) {
					tempMap[i][j]=-1;
					}
					if (map[i][j] > 0)
						spread(tempMap,i, j);
				}
			}
//		for(int i = 0 ; i < R; i++) {
//			System.out.println(Arrays.toString(tempMap[i]));
//		}
//		System.out.println("===============================");
			moveMungi(tempMap,list.get(0).y, list.get(0).x, 1);
			moveMungi(tempMap,list.get(1).y, list.get(1).x, 2);
//		for(int i = 0 ; i < R; i++) {
//			System.out.println(Arrays.toString(tempMap[i]));
//		}
//		System.out.println("================================================================");
			map = tempMap;
			T--;
		}
		int cnt = 0;
		for(int i = 0; i<R; i++) {
			for(int j = 0 ; j < C; j++) {
				if(map[i][j]>0)cnt+=map[i][j];
			}
		}
		
		System.out.println(cnt);
	}

	private static void moveMungi(int[][] tempMap,int y, int x, int val) {
		if (val == 1) {
			int ny = y;
			int nx = x;
			while (ny > 0) {
				tempMap[ny][nx] = tempMap[--ny][nx];
			}
			while (nx < C - 1) {
				tempMap[ny][nx] = tempMap[ny][++nx];
			}
			while (ny < y) {
				tempMap[ny][nx] = tempMap[++ny][nx];
			}
			while (nx > 1) {
				tempMap[ny][nx] = tempMap[ny][--nx];
			}
			tempMap[ny][nx] = 0;
			tempMap[y][x] = -1;

		} else {
			int ny = y;
			int nx = x;
			while (ny < R - 1) {
				tempMap[ny][nx] = tempMap[++ny][nx];
			}
			while (nx < C - 1) {
				tempMap[ny][nx] = tempMap[ny][++nx];
			}
			while (ny > y) {
				tempMap[ny][nx] = tempMap[--ny][nx];
			}
			while (nx > 1) {
				tempMap[ny][nx] = tempMap[ny][--nx];
			}
			tempMap[ny][nx] = 0;
			tempMap[y][x] = -1;
		}
	}

	private static void spread(int[][] tempMap,int y, int x) {

		int cnt = canSpread(y, x);
		int ny, nx;
		for (int i = 0; i < 4; i++) {

			ny = y + dy[i];
			nx = x + dx[i];
			if (!isRange(ny, nx) || map[ny][nx] == -1)
				continue; // 범위를 벗어나거나 공기 청청기가 있을 때는 안 퍼트린다.

			tempMap[ny][nx] += map[y][x] / 5;
		}
		tempMap[y][x] += map[y][x] - map[y][x] / 5 * cnt;
	}

	private static int canSpread(int y, int x) {
		int cnt = 0;
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (!isRange(ny, nx) || map[ny][nx] == -1)
				continue;
			cnt++;
		}
		return cnt;
	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == R || nx < 0 || nx == C)
			return false;
		return true;
	}

	static class Machine {
		int y, x;

		Machine(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
