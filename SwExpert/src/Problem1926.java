import java.util.Scanner;

public class Problem1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		
		for(int i =1; i <=n;i++) {
			cnt = 0;
			if(i<10) {
				if(i%3==0)cnt++;
			} else if(i>=10 && i <100) {
				if((i/10)%3==0)cnt++;
				if((i%10)%3==0 && (i%10)!=0)cnt++;
			} else if(i>=100 && i <1000) {
				if((i/100)%3==0)cnt++;
				if(((i/10)%10)%3==0 && ((i/10)%10!=0))cnt++;
				if((i%10)%3==0 && (i%10)!=0)cnt++;
			} else break;
			
			switch(cnt) {
			case 1:
				System.out.print("- ");
				break;
			case 2:
				System.out.print("-- ");
				break;
			case 3:
				System.out.print("--- ");
				break;
			default:
				System.out.print(i+ " ");
			}
			
		

		}
	}
	
}
