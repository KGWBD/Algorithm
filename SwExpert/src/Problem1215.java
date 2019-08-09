import java.util.Scanner;

public class Problem1215 {
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = null;
		for (int t = 1; t <= 10; t++) {

			int length = sc.nextInt();
			sc.nextLine();
			char[][] arr = new char[100][100];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLine().toCharArray();
			}
			cnt = 0;
			checkRow(arr, length);
			checkColumn(arr, length);
			System.out.format("#%d %d",t,cnt);
		}
	}

	private static void checkRow(char[][] arr, int length) {
		StringBuilder sb = null;
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr.length - length + 1; x++) {
				sb = new StringBuilder();
				for (int k = x; k < x + length; k++) {
					sb.append(arr[y][k]);
				}
				if (sb.toString().equals(sb.reverse().toString())) {
					cnt++;
				}
			}
		}
	}

	private static void checkColumn(char[][] arr, int length) {
		StringBuilder sb = null;
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr.length - length + 1; y++) {
				sb = new StringBuilder();
				for (int k = y; k < y + length; k++) {
					sb.append(arr[k][x]);
				}
				if (sb.toString().equals(sb.reverse().toString())) {
					cnt++;
				}
			}
		}
	}
}
