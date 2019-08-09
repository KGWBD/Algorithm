import java.util.Scanner;

public class Problem1216 {
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = null;
		for (int t = 1; t <= 10; t++) {
			char[][] arr = new char[100][100];
			int testNum = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLine().toCharArray();
			}
			ans = 0;
			checkRow(arr, 1);
			checkColumn(arr, 1);
			System.out.format("#%d %d\n", t, ans);
		}
	}

	private static void checkRow(char[][] arr, int length) {
		if(length>arr.length) {
			return;
		}
		while(ans>=length) {
			length +=1;
		}
		StringBuilder sb = null;
		outer:for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr.length - length + 1; x++) {
				sb = new StringBuilder();
				for (int k = x; k < x + length; k++) {
					sb.append(arr[y][k]);
				}
				if (sb.toString().equals(sb.reverse().toString())) {
					ans = length;
					break outer;
				}
			}
		}
		checkRow(arr,length+1);
	}

	private static void checkColumn(char[][] arr, int length) {
		if(length>arr.length) {
			return;
		}
		while(ans>=length) {
			length +=1;
		}
		StringBuilder sb = null;
		outer:for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr.length - length + 1; y++) {
				sb = new StringBuilder();
				for (int k = y; k < y + length; k++) {
					sb.append(arr[k][x]);
				}
				if (sb.toString().equals(sb.reverse().toString())) {
					ans = length;
					break outer;
				}
			}
		}
		checkColumn(arr,length+1);
	}
}
