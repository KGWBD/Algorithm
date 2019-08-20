import java.util.Arrays;

// 셀렉션 sort 재귀로 작성하기
public class SelectionRecursionTest {

	public SelectionRecursionTest() {
		int[] arr = {4,3,8,7,9,4};
		selectionSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		new SelectionRecursionTest();

	}
	public void selectionSort(int a[], int length){
      recurSelectionSort(a, length, 0);
    }

    static void recurSelectionSort(int a[], int length, int index){
        if (index == length)
           return;
        int k = minIndex(a, index, length-1);
        if (k != index){
           int temp = a[k]; // 교환
           a[k] = a[index];
           a[index] = temp;
        }
        recurSelectionSort(a, length, index + 1);
    }
    static int minIndex(int a[], int i, int j) {
        if (i == j)
            return i;
        int k = minIndex(a, i + 1, j);
        return (a[i] < a[k])? i : k;
    }
}
