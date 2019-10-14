import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj17143 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Shark[][] map;
	static LinkedList<Shark> list;
	static int R, C, M;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new LinkedList<>();
		int r, c, s, d, z;
		Shark shark;
		map = new Shark[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken()) - 1;
			z = Integer.parseInt(st.nextToken());
			shark = new Shark(r, c, s, d, z);
			list.add(shark);
			map[r][c] = shark;
		} // 상어를 리스트에 입력한다. 이 상어들로 움직일 것.
		int ans = 0;
		if (M != 0) {
			for (int i = 1; i <= C; i++) {
				for (int j = 0; j <= R; j++) {
					if (map[j][i] != null) {
						shark = map[j][i];
						list.remove(shark);
						ans += shark.z;
						break;
					}
				} // 가까운 상어 잡기

				moveShark();
			} // 사람움직이기
		}
		System.out.println(ans);

	}

	private static void moveShark() {
		Shark[][] tempMap = new Shark[R + 1][C + 1];
		Shark shark;
		int size = list.size();
		int ny, nx, speed, dir;
		for (int i = 0; i < size; i++) { // 한마리씩 꺼내본다.
			shark = list.poll();
			ny = shark.r;
			nx = shark.c;
			dir = shark.d;
			speed = shark.s;
			if(dir==1 || dir==0)speed = speed%(R*2-2);
			else speed = speed%(C*2-2);
			while (speed > 0) {
				ny += dy[dir];
				nx += dx[dir];
				if (!isRange(ny, nx)) {
					ny -= dy[dir];
					nx -= dx[dir];
					dir = chageDirection(dir);
					ny += dy[dir];
					nx += dx[dir];
				}
				speed--;
			} // 다 움직임.

			if (tempMap[ny][nx] == null) {
				Shark newShark = new Shark(ny, nx, shark.s, dir, shark.z);
				tempMap[ny][nx] = newShark;
				list.add(newShark);
			} else {
				if (tempMap[ny][nx].z < shark.z) {
					list.remove(tempMap[ny][nx]);
					Shark newShark = new Shark(ny, nx, shark.s, dir, shark.z);
					tempMap[ny][nx] = newShark;
					list.add(newShark);
				}
			}
		} // 움직이고 잡아먹음.

		map = tempMap;

	}

	private static int chageDirection(int dir) {
		int newDir = 0;
		switch (dir) {
		case 0:
			newDir = 1;
			break;
		case 1:
			newDir = 0;
			break;
		case 2:
			newDir = 3;
			break;
		case 3:
			newDir = 2;
			break;
		}
		return newDir;
	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 1 || nx < 1 || ny == R + 1 || nx == C + 1)
			return false;
		return true;
	}

	static class Shark {
		int r, c, s, d, z;

		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
