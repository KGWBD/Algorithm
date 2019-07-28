import java.util.Scanner;

public class Problem1989 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int i = 1; i <=testCase;i++) {
			
		
		String str = sc.next();
		int value = checkValue(str,0,str.length()-1);
		System.out.println(String.format("#%d %d", i,value));
		}
		sc.close();
		
	}

	public static int checkValue(String str, int start, int end){
		if(start>end) {
			return 1;
		} else {
			if(str.charAt(start) == str.charAt(end)) {
				return checkValue(str,start+1,end-1);
			} else {
				return 0;
			}
		}
	
		
		
		
		
		
	}
}
