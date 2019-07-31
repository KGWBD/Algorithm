import java.util.Scanner;

public class Problem1945 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		
		int[] arr = { 2, 3, 5, 7, 11 };
		int[] result = new int[5];
		int temp,cnt,num;
	
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			StringBuilder sb = new StringBuilder();
			num = sc.nextInt();
			
			for (int i = arr.length-1; i >= 0; i--) {
				temp = arr[i];
				cnt = 0;
				while (num % temp == 0) {
					cnt++;
					num /= temp;
				}
				result[i] = cnt;
			}
			sb.append("#"+t);
			for(int i=0;i<5;i++) {
				sb.append(" " + result[i]);
			}
			System.out.println(sb.toString());
		}
		
	}

}
