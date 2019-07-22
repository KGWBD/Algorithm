import java.util.Scanner;

public class Problem1936 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int win=0;
		int lose=0;
		
		while(win==0 && lose ==0) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			if(num1 == 1) {
				if(num2 == 2)lose++;
				else if(num2==3)win++;
			} else if(num1 == 2) {
				if(num2 == 1)win++;
				else if(num2 == 3)lose++;
			} else if(num1 == 3) {
				if(num2==1)lose++;
				else if(num2==2)win++;
			}
		}
		if(win==1) System.out.println("A");
		else if(lose==1) System.out.println("B");
		
		
	}
}
