import java.util.Arrays;
import java.util.Scanner;

public class permutation {
	int idx = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String[] s = str.split("");
		int[] arr = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		perm(arr, 0);

	}

	private static void perm(int[] arr, int depth) {
		if (depth == arr.length) {
			
			int n1 = checkTriple(arr);
			int n2 = checkRun(arr);
			if(n1+n2 == 2) {
				System.out.println("baby-gin");
				System.out.println(Arrays.toString(arr));
			}
		}

		for (int i = depth; i < arr.length; i++) {
			swap(arr, depth, i);
			perm(arr, depth + 1);
			swap(arr, depth, i);

		}

	}

	private static int checkRun(int[] arr) {
		boolean flag = true;
		int n = 0;
		int size = arr.length / 2;
		for (int i = 0; i < size - 1; i++) {
			if (arr[i]+1 != arr[i + 1]) {
				flag = false;
				break;
			}
		}
		if (flag) {
			n++;
		} else {
			flag = true;
		}

		for (int i = size; i < arr.length - 1; i++) {
			if (arr[i]+1 != arr[i + 1]) {
				flag = false;
				break;
			}
		}
		if (flag) {
			n++;
		}
		return n;
		
		
	}

	private static int checkTriple(int[] arr) {
		boolean flag = true;
		int n = 0;
		int size = arr.length / 2;
		for (int i = 0; i < size - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				flag = false;
				break;
			}
		}
		
		if (flag) {
			n++;
		}else {
			flag=true;
		}

		for (int i = size; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				flag = false;
				break;
			}
		}
		
		if (flag) {
			n++;
		}
		
		return n;

	}

	private static void swap(int[] s, int depth, int i) {
		int tmp = s[depth];
		s[depth] = s[i];
		s[i] = tmp;
	}
}
