
public class SearchTest {

	public static void main(String[] args) {
		int[] arr = {1,3,5,8,2,9,6};
		int key = 8;
		boolean flag = searchKey(key,arr);
		System.out.println(flag);
		
	}

	static boolean searchKey(int key, int[] arr) {
		boolean flag = false;
		
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i]==key) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}
}
