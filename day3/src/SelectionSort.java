import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {1,4,2,28,30,7,3,16,5,4};
		int min,temp, minIdx=0;
		
		System.out.println(Arrays.toString(arr));
		System.out.println("======================");
		for(int i = 0; i<arr.length-1;i++) {
			min = 987_654_321;
			minIdx=0;
			for(int j=i;j<arr.length;j++) {
				if(min>arr[j]) {
					min = arr[j];
					minIdx=j;
				}
			}
			temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		System.out.println(Arrays.toString(arr));
		
		
		for(int i = 0; i < arr.length-1;i++) {
			min = i;
			for(int j =i+1 ; j < arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
					
				}
			}
			if(min != i) {
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
