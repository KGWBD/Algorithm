
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem1204 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
//		int testCase = sc.nextInt();
		int[] arr = null;
		int size = 1000;

//		for (int t = 1; t <= testCase; t++) {
			arr = new int[100 + 1];
			int testNum = sc.nextInt();
			for (int i = 0; i < size; i++) {
				arr[sc.nextInt()]++;
			}
			int max = -1;
			int idx = -1;
			for (int i = 0; i < arr.length; i++) {
				if (max <= arr[i]) {
					max = arr[i];
					idx = i;
				}
			}
			
			System.out.println(Arrays.toString(arr));
//			System.out.format("#%d %d\n",t,idx);

//		}

	}
}
