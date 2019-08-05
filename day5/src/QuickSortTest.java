import java.util.Arrays;

public class QuickSortTest {
	public static void main(String[] args) {
		int[] arr = { 5, 6, 3, 6, 8, 9, 1, 2, 4 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int start, int end) {
		if (start > end) {
			return;
		}
		int pivot = start;
		int L = start + 1;
		int R = end;
		int temp;
		while (L <= R) {
			while (arr[pivot] >= arr[L] && L < end)
				L++;
			while (arr[pivot] <= arr[R] && R > start)
				R--;

			if (L < R) {
				temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			} else {
				temp = arr[pivot];
				arr[pivot] = arr[R];
				arr[R] = temp;
			}
		}
		quickSort(arr, start, R - 1);
		quickSort(arr, R + 1, end);
	}

}
