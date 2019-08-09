
import java.util.ArrayList;
import java.util.Scanner;

public class Problem6808 {
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> gyu = null;
		ArrayList<Integer> inyoeng = null;
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			cnt=0;
			gyu = new ArrayList<>();
			inyoeng  = new ArrayList<>();
			for (int i = 0; i < 18; i++) {
				inyoeng.add(i + 1);
			}
			for (int i = 0; i < 9; i++) {
				gyu.add(sc.nextInt());
				inyoeng.remove(gyu.get(i));
			}
			int[] inyoengArr = new int[9];
			int[] gyuArr = new int[9];
			for (int i = 0; i < 9; i++) {
				inyoengArr[i] = inyoeng.get(i);
				gyuArr[i] = gyu.get(i);
			}

			permutation(gyuArr, inyoengArr, 0);
			
			System.out.format("#%d %d %d\n", t, cnt, 362880 - cnt);
		}
	}

	private static void versus(int[] gyuArr, int[] inyoenArr) {
		int gyuSum = 0;
		int inSum = 0;
		int n, m;
		for (int i = 0; i < 9; i++) {
			n = gyuArr[i];
			m = inyoenArr[i];
			if (n > m)
				gyuSum += n + m;
			else
				inSum += m + n;
		}
		if(gyuSum>inSum)cnt++;
	}

	private static void permutation(int[] gyuArr, int[] inyoengArr, int depth) {
		if (depth == gyuArr.length) {
			versus(gyuArr, inyoengArr);
			return;
		}

		for (int i = depth; i < inyoengArr.length; i++) {
			swap(inyoengArr, depth, i);
			permutation(gyuArr, inyoengArr, depth + 1);
			swap(inyoengArr, depth, i);
		}

	}

	private static void swap(int[] inyoengArr, int depth, int i) {
		int temp = inyoengArr[depth];
		inyoengArr[depth] = inyoengArr[i];
		inyoengArr[i] = temp;
	}

}
