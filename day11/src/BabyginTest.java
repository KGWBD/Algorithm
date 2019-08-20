public class BabyginTest {

	static int cnt = 0;
	static boolean result = false;

	public static void main(String[] args) {
		int[] num = { 1, 1, 1, 1, 2, 3 };
		check(num);
		System.out.println(cnt + " " + result);
	}

	static void check(int[] num) {
		doPerm(num, 0);
	}

	static boolean promissing(int[] num) {
		boolean f = false;
		if (num[0] == num[1] && num[1] == num[2]) {
			f = true;
		}
		if (num[0] + 1 == num[1] && num[1] + 1 == num[2]) {
			f = true;
		}
		return f;
	}

	static void doPerm(int[] arr, int pivot) {
		if (pivot == 3 && !promissing(arr)) {
			return;
		}
		if (pivot == arr.length) {
			judge(arr);
		}
		for (int i = pivot; i < arr.length; i++) {
			swap(arr, i, pivot);
			doPerm(arr, pivot + 1);
			swap(arr, i, pivot);
		}
	}

	static void judge(int[] num) {
		if (num[3] == num[4] && num[4] == num[5]) {
			result = true;
		}
		if (num[3] + 1 == num[4] && num[4] + 1 == num[5]) {
			result = true;
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
