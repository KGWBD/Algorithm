import java.util.Arrays;
import java.util.Scanner;

public class Boj3985 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		int[] cake = new int[L+1];
		int expected = 0;
		int expectedIdx = 0;
		int real = 0;
		int realidx = 0;
		for(int i = 1 ; i <= N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cnt = 0;
			if(expected<end-start) {
				expected = end-start;
				expectedIdx = i;
			}
			for(int k = start; k <=end;k++) {
				if(cake[k]==0) {
				cake[k] = i;
				cnt++;
				}
			}
			if(real<cnt) {
				real = cnt;
				realidx = i;
			}
		}
		
		System.out.println(expectedIdx);
		System.out.println(realidx);
		
		
		
	}
	
}
