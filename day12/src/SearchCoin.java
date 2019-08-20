
public class SearchCoin {
	static final int[] coins = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

	public static void main(String[] args) {

	
		int start = 0;
		int end = coins.length;
		int middle = end / 2;

		while (end-start > 1) {
			int sum1 = 0;
			int sum2 = 0;
			
			for (int i = start; i < middle; i++) {
				sum1 += coins[i];
			}
			for (int i = middle; i < end; i++) {
				sum2 += coins[i];
			}

			if (sum1 > sum2) {
				start = middle;
			} else if(sum1<sum2){
				end = middle;
			} else {
				System.out.println(middle);
				break;
			}
			middle = middle%2==0?(start + end) / 2:(start + end+1) / 2;
		}
		System.out.println("start"+start);

	}
}
