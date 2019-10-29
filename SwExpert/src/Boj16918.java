import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16918 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] boom;
	static char[][] ans;
	static int R, C, N;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ans = new char[R][C];
		boom = new int[R][C];
		String temp;
		for (int i = 0; i < R; i++) {
			temp = br.readLine();
			for (int j = 0; j < C; j++) {
				if (temp.charAt(j) == '.')
					boom[i][j] = 0;
				else
					boom[i][j] = 1;
			}
		} // 초기 값 입력
		Queue<Position> list = new LinkedList<Boj16918.Position>();

		// N번 반복할거임
		int n = 1;
		list = addTime();
		while (n < N) {
				list = addTime();
				moveBoomberMan();
			if (list.size() != 0) {
				boomboom(list); // 폭탄 터트림
			}
			
			n++;
		}
		printBoom();
		bw.close();
	}

	private static Queue<Position> addTime() {
		Queue<Position> temp = new LinkedList<Boj16918.Position>();
		int n;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				n = boom[i][j];
				if (n != 0)
					boom[i][j]++;

				if (boom[i][j] == 4)
					temp.add(new Position(i, j));
			}
		}
		return temp;

	}

	private static void printBoom() throws IOException {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (boom[i][j] > 0)
					bw.write("O");
				else
					bw.write(".");
			}
			bw.write("\n");
		}
	}

	private static void boomboom(Queue<Position> list) {
		Position pos;
		int ny, nx;
		while (!list.isEmpty()) {
			pos = list.poll();
			boom[pos.y][pos.x] = 0;
			for (int i = 0; i < 4; i++) {
				ny = pos.y + dy[i];
				nx = pos.x + dx[i];

				if (!isRange(ny, nx))
					continue;

				boom[ny][nx] = 0;
			}
		}
	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == R || nx < 0 || nx == C)
			return false;
		return true;
	}

	private static void moveBoomberMan() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (boom[i][j] == 0)
					boom[i][j]++;
			}
		}

	}

	static class Position {
		int y, x;

		Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
