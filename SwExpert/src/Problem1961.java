import java.util.Scanner;

public class Problem1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = null;
		int testCase = sc.nextInt();
//		sc.nextLine();
		int[][] arr = null;
		int n = 0;
		
		for (int t = 1; t <= testCase; t++) {

			n = sc.nextInt();
//			sc.nextLine();
			arr = new int[n][n];
			int size = arr.length;
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int idx = 0;
			System.out.println("#" + t);
			for (int i = 0; i < size; i++) {
				sb = new StringBuilder();
				idx = size - 1;
				while (idx >= 0) {
					sb.append(arr[idx--][i]);
				}
				sb.append(" ");
				idx = size - 1;
				while (idx >= 0) {
					sb.append(arr[size - i - 1][idx--]);
				}
				idx = 0;
				sb.append(" ");
				while (idx < size) {
					sb.append(arr[idx++][size - i - 1]);
				}

				System.out.println(sb.toString());

			}
		}

	}
}
