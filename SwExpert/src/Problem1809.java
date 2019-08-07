import java.util.Scanner;
import java.util.Stack;

public class Problem1809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> top = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		
		int topNum = sc.nextInt();
		int[] result = new int[topNum+1];
		int temp = 0;
//		6 9 5 7 4
		outer:for(int i = 1; i <= topNum; i++) {
			
			 temp = sc.nextInt(); // 자기 자신.
			 
			while(!top.isEmpty()) {
				
				if(temp<top.peek()) {
					result[i] = index.peek();
					top.add(temp);
					index.add(i);
					continue outer;
				} else {
					top.pop();
					index.pop();
				}
			}
			top.add(temp);
			index.add(i);
			result[i] = 0 ;
	
		}
		for(int i = 1;i<result.length;i++) {
			System.out.print(result[i] + " ");
		}
		
		
	}
}
