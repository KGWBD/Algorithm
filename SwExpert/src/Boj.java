import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, R, C, D;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] map;
	static int clear;

	public static void main(String[] args) throws NumberFormatException, IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(R, C, D);
		System.out.println("-----------");

		System.out.println(clear);

	}

	private static void dfs(int y, int x, int dir) {
		boolean flag = false;
		System.out.println("---------------------------------------");
		print();
		map[y][x] = 9;
		clear++;
		int ny, nx;
		int cnt = 1;
		dir = turnLeft(dir);
		ny = y + dy[dir];
		nx = x + dx[dir];
		while (map[ny][nx] != 0 && cnt != 4) {
			dir = turnLeft(dir);
			ny = y + dy[dir];
			nx = x + dx[dir];
			cnt++;
			if (isRange(ny, nx))
				continue;
		}

		if (cnt < 4) {
			dfs(ny, nx, dir);
		} else {
			dir = turnLeft(dir);
			dir = turnLeft(dir);
			ny = y + dy[dir];
			nx = x + dx[dir];
			if (isRange(ny, nx)) {
				return;
			}
			dir = turnLeft(dir);
			dir = turnLeft(dir);
			if (map[ny][nx] != 1) {
				dfs(ny, nx, dir);
			}
		}

	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == M)
			return true;
		return false;

	}

	private static int turnLeft(int dir) {
		if (dir - 1 < 0)
			return 3;
		else
			return dir - 1;

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();

		}
	}

}
