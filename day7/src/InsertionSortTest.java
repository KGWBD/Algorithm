import java.util.Arrays;

public class InsertionSortTest {
	public static void main(String[] args) {
		int[] arr = {1,4,2,9,6,7,8,5,4};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}

	private static void insertionSort(int[] arr) {
		int temp = 0;
		int j;
		for(int i =1; i < arr.length;i++) {
			temp = arr[i];
			for(j = i-1; j>=0; j--) {
				if(temp>=arr[j] ) {
					break;
				}
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
			
		}
		
	}
	
}
