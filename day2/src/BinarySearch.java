public class BinarySearch {

	static int binarySearch(int key, int[] arr) {
		int left = 0;    			// 배열의 첫 번째 인덱스
		int right = arr.length -1;   // 배열의 마지막 인덱스
		int mid;
		
		while(left <= right) {
			mid = (left + right) / 2; // 배열의 중간값
			
			if(arr[mid]==key) {		
				return mid;			  // 원하는 값을 찾으면 인덱스를 리턴하고 함수 종료
			} else if (arr[mid] > key) {
				right = mid -1;
			} else {
				left = mid +1;
			}				  
		}
		return -1;	 //원하는 값이 없으면 -1을 리턴
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 8, 10, 11, 13, 14, 16, 18, 20, 22};
		int idx = binarySearch(12, arr);   // arr배열에서 12를 탐색하고 index 리턴
		System.out.println(String.format("찾는 값 12의 인덱스는 %d",idx));
	}
}
