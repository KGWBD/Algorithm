import java.util.Arrays;
import java.util.Scanner;

public class Problem1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {

			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int sum = 0;
			for (int i = 1; i < 9; i++) {
				sum += arr[i];
			}
			long average = Math.round(sum/8.0);
			
			System.out.println(String.format("#%d %d", t,average));
		}
	}
}
