import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static int R, C;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int cycle = 0;
		while (true) {
			boolean flag = false;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '.')
						continue;
					int cnt = check(i,j);
					if (map[i][j] - '0' <= cnt) {
						map[i][j] = '.';
					}
				}
			}
			
			printMap();
			cycle++;
			if(cycle==2)break;

		}
		
	}

	private static void printMap() {
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("==========================");

	}

	private static int check(int y, int x) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			if (map[y + dy[i]][x + dx[i]] == '.') {
				cnt++;
			}
		}
		return cnt;

	}

}