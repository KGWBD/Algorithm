import java.util.Scanner;

public class Problem4371 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int num = sc.nextInt();
			int[] arr = new int[num - 1];
			int firstDay = sc.nextInt();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt() - 1;
			}
			int cnt = arr.length;
			for (int i = arr.length - 1; i > 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					if (arr[i] % arr[j] == 0) {
						cnt--;
						break;
					}
				}
			}
			System.out.format("#%d %d", t,cnt);
		}
	}
}
