import java.util.Scanner;

public class Problem1976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour, hour1, hour2, minute, minute1, minute2;

		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			hour1 = sc.nextInt();
			minute1 = sc.nextInt();
			hour2 = sc.nextInt();
			minute2 = sc.nextInt();
			hour = hour1 + hour2;
			minute = minute1 + minute2;
			if (minute >= 60) {
				minute -= 60;
				hour += 1;
			}
			if (hour / 13 > 0) {
				hour = hour -12;
			}
			System.out.format("#%d %d %d\n",t, hour, minute);
		}
	}
}
