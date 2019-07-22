public class BinarySearch {

	static int binarySearch(int key, int[] arr) {
		int left = 0;    			// �迭�� ù ��° �ε���
		int right = arr.length -1;   // �迭�� ������ �ε���
		int mid;
		
		while(left <= right) {
			mid = (left + right) / 2; // �迭�� �߰���
			
			if(arr[mid]==key) {		
				return mid;			  // ���ϴ� ���� ã���� �ε����� �����ϰ� �Լ� ����
			} else if (arr[mid] > key) {
				right = mid -1;
			} else {
				left = mid +1;
			}				  
		}
		return -1;	 //���ϴ� ���� ������ -1�� ����
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 8, 10, 11, 13, 14, 16, 18, 20, 22};
		int idx = binarySearch(12, arr);   // arr�迭���� 12�� Ž���ϰ� index ����
		System.out.println(String.format("ã�� �� 12�� �ε����� %d",idx));
	}
}
