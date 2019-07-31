import java.util.Scanner;

public class Problem2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {

			int n = sc.nextInt();
			sc.nextLine();
			char[][] arr = new char[n][n];
			int size = arr.length;
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextLine().toCharArray();
			}
			
			int left = size / 2;
			int right = size / 2 + 1;
			
			int sum = 0;
			for (int i = 0; i <= size/2; i++) {
				for (int j = left; j < right; j++) {
					sum += arr[i][j] - '0';
					sum += arr[size-1-i][j]-'0';
				}
					left--;
					right++;
			}
			for(int i =0;i<size;i++) {
				sum-= arr[size/2][i]-'0';
			}
			System.out.format("#%d %d\n",t,sum);
		}

	}

}
