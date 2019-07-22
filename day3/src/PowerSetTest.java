
public class PowerSetTest {
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
//		methoda(arr);
		methodb(arr);
	}
	
	static void methodb(int[] arr) {
		int size = 1 << arr.length;
		for( int i = 0; i < size; i++) {
			for(int j = 0; j < arr.length; j++) {
				if((i & (1 <<j)) != 0 ) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
	}

	static void methoda(int[] arr) {
		boolean[] flags = new boolean[arr.length];
		for(int i = 0 ; i < 2; i ++) {
			flags[0] = i%2 == 0 ?false: true;
			for(int j = 0; j < 2; j++) {
				flags[1] = i%2 == 0 ?false: true;
				for(int k = 0; k < 2; k++) {
					flags[2] = i%2 == 0 ?false: true;
					for(int l = 0; l < 2; l++) {
						flags[3] = i%2 == 0 ?false: true;
						printArray(flags, arr);
					
					}
				}
			}
		}
	}

	 static void printArray(boolean[] flags, int[] arr) {
		for(int i = 0; i< arr.length; i++) {
			if(flags[i]) {
				System.out.print(arr[i] + " ");
			}
			
		}
		System.out.println();
	}
	
	
	
}
