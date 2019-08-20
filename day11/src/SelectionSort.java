
public class SelectionSort {
	public static void main(String[] args) {

		int[] arr = { 1, 3, 4, 2, 5, 1, 2, 3, 4 };
		
		int min;
		for(int i = 0 ; i < arr.length-1;i++) {
			min = i;
			for(int j = i+1; j< arr.length;j++) {
				if(arr[min]>arr[j]) {
					min = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}

	}

}
