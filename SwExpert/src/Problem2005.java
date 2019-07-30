import java.util.Scanner;

public class Problem2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 1; t <= testCase; t++) {
			System.out.println("#" + t);
			int row = sc.nextInt();
			int[][] arr = new int[row][];

			for (int i = 0; i < row; i++) {
				arr[i] = new int[i + 1];
				for (int j = 0; j < i + 1; j++) {

					if (j == 0 || j == i) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];

					}
					System.out.print(arr[i][j] + " ");

				}
				System.out.println();
			}
			
		}

		sc.close();
	}
}
