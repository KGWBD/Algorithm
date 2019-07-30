import java.util.Scanner;

public class Problem2806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			cnt=0;
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			dfs(arr, 0);
			System.out.println(String.format("#%d %d"	, t,cnt));
		}
	}

	static int cnt = 0;

	private static void dfs(int[] arr, int depth) {
		boolean flag = false;
		if (depth == arr.length) {
//			flag = checkNQueen(arr);
//			if (flag) {
			cnt++;
//			}
			return;
		}

		for (int i = 1; i <= arr.length; i++) {
			arr[depth] = i;
			if (isPromising(arr, depth)) {
				dfs(arr, depth + 1);

			}

		}

	}

	private static boolean isPromising(int[] arr, int depth) {
		int size = arr.length;
		boolean flag = true;
		for (int i = 0; i < depth; i++) {
			if (arr[i] == arr[depth]) {
				flag = false;
				break;
			} else if (Math.abs(arr[i] - arr[depth]) == (depth - i)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	private static boolean checkNQueen(int[] arr) {
		int size = arr.length;
		boolean flag = true;
		outer: for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] == arr[j]) {
					flag = false;
					break outer;
				} else if (Math.abs(arr[i] - arr[j]) == (j - i)) {
					flag = false;
					break outer;
				}
			}
		}
		return flag;
	}
}
