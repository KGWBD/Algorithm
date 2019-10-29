import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem6109 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String type = st.nextToken();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			switch (type) {
			case "up":
				up();
				break;
			case "down":
				down();
				break;
			case "left":
				left();
				break;
			case "right":
				right();
				break;
			}
			bw.write("#" + t + "\n");
			printMap();
		}
		bw.close();
	}

	private static void right() {
		int cur, temp, tempJ;
		for (int i = 0; i < N; i++) {
			inner: for (int j = N - 1; j > 0; j--) {
				cur = map[i][j];
				tempJ = j;
				if (cur == 0) { // 현재가 0이라면
					while (tempJ >= 0) { // 끝까지가면서
						if (map[i][tempJ] == 0)
							tempJ--; // 0이면 계속가
						else { // 아니면 현재에 그 값을 넣고 그 값은 0으로
							map[i][j] = map[i][tempJ];
							map[i][tempJ] = 0;
							j++;
							break;
						}
					}
				} else {
					tempJ--;
					while (tempJ >= 0) {
						if (map[i][tempJ] == 0)
							tempJ--; // 0이면 계속가
						else if (map[i][tempJ] == cur) {
							map[i][j] += cur;
							map[i][tempJ] = 0;
							break;
						} else {
							continue inner;
						}
					}
				}

			}

		}
	}

	private static void left() {
		int cur, temp, tempJ;
		for (int i = 0; i < N; i++) {
			inner: for (int j = 0; j < N - 1; j++) {
				cur = map[i][j];
				tempJ = j;
				if (cur == 0) { // 현재가 0이라면
					while (tempJ < N) { // 끝까지가면서
						if (map[i][tempJ] == 0)
							tempJ++; // 0이면 계속가
						else { // 아니면 현재에 그 값을 넣고 그 값은 0으로
							map[i][j] = map[i][tempJ];
							map[i][tempJ] = 0;
							j--;
							break;
						}
					}
				} else {
					tempJ++;
					while (tempJ < N) {
						if (map[i][tempJ] == 0)
							tempJ++; // 0이면 계속가
						else if (map[i][tempJ] == cur) {
							map[i][j] += cur;
							map[i][tempJ] = 0;
							break;
						} else {
							continue inner;
						}
					}
				}

			}

		}

	}

	private static void printMap() throws IOException {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}

	}

	private static void down() {

		int cur, temp, tempI;
		for (int j = 0; j < N; j++) {
			inner: for (int i = N - 1; i > 0; i--) {
				cur = map[i][j];
				tempI = i;
				if (cur == 0) { // 현재가 0이라면
					while (tempI >= 0) { // 끝까지가면서
						if (map[tempI][j] == 0)
							tempI--; // 0이면 계속가
						else { // 아니면 현재에 그 값을 넣고 그 값은 0으로
							map[i][j] = map[tempI][j];
							map[tempI][j] = 0;
							i++;
							break;
						}
					}
				} else {
					tempI--;
					while (tempI >= 0) {
						if (map[tempI][j] == 0)
							tempI--; // 0이면 계속가
						else if (map[tempI][j] == cur) {
							map[i][j] += cur;
							map[tempI][j] = 0;
							break;
						} else {
							continue inner;
						}
					}
				}

			}

		}

	}

	private static void up() throws IOException {
		int cur, temp, tempI;
		for (int j = 0; j < N; j++) {
			inner: for (int i = 0; i < N - 1; i++) {
				cur = map[i][j];
				tempI = i;
				if (cur == 0) { // 현재가 0이라면
					while (tempI < N) { // 끝까지가면서
						if (map[tempI][j] == 0)
							tempI++; // 0이면 계속가
						else { // 아니면 현재에 그 값을 넣고 그 값은 0으로
							map[i][j] = map[tempI][j];
							map[tempI][j] = 0;
							i--;
							break;
						}
					}
				} else {
					tempI++;
					while (tempI < N) {
						if (map[tempI][j] == 0)
							tempI++; // 0이면 계속가
						else if (map[tempI][j] == cur) {
							map[i][j] += cur;
							map[tempI][j] = 0;
							break;
						} else {
							continue inner;
						}
					}
				}

			}
		}
	

	}
}
