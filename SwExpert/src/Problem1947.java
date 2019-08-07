import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem1947 {
	static Set<Integer> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[10][10];
		int testCase = sc.nextInt();
		boolean flag1, flag2, flag3;
		int result;
		for (int t = 1; t <= 10; t++) {
			result = 1;
			
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			flag1 = flag2 = flag3 = false;
			flag1 = checkRow(arr);
			flag2 = checkColumn(arr);
			flag3 = checkRec(arr);
			if (flag1 || flag2 || flag3) {
				result = 0;
			}
			
			System.out.format("#%d %d%n",t,result);
		}
	}

	private static boolean checkRec(int[][] arr) {
		set = new HashSet<Integer>();
		int start;
		start = 1;
		while (start < 8) {
			for (int i = start; i < start + 3; i++) {
				for (int j = start; j < start + 3; j++) {
					set.add(arr[i][j]);
				}
			}
			if (set.size() != 9) {
				return true;
			}
			set.clear();
			start += 3;
		}
		return false;
	}

	private static boolean checkRow(int[][] arr) {
		set = new HashSet<Integer>();
		for (int y = 1; y < 10; y++) {
			for (int x = 1; x < 10; x++) {
				set.add(arr[y][x]);
			}
			if (set.size() != 9) {
				return true;
			}
			set.clear();
		}
		return false;
	}

	private static boolean checkColumn(int[][] arr) {
		set = new HashSet<Integer>();
		for (int x = 1; x < 10; x++) {
			for (int y = 1; y < 10; y++) {
				set.add(arr[y][x]);
			}
			if (set.size() != 9) {
				return true;
			}
			set.clear();
		}
		return false;
	}

}
