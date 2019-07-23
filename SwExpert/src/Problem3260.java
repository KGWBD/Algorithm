import java.util.Scanner;
import java.util.Stack;

public class Problem3260{

	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> ans = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t = 1; t <= testCase; t++) {
			
			char[] chars1 = sc.next().toCharArray();
			char[] chars2 = sc.next().toCharArray();
			
			for(int i = 0; i < chars1.length; i++) {
				stack1.push(chars1[i]-'0');
			}
			for(int i = 0; i < chars2.length; i++) {
				stack2.push(chars2[i]-'0');
			}
			
			int size = stack1.size() >= stack2.size() ? stack1.size(): stack2.size();
			int carry = 0;
			for(int i = 0; i < size; i++) {
				int a = 0;
				int b = 0;
				int nam = 0;
				
				if(stack1.empty()) {
					a = stack2.pop() + carry;
					carry = a / 10;
					nam = a % 10;
					
				} else if(stack2.isEmpty()) {
					a = stack1.pop() + carry;
					carry = a / 10;
					nam = a % 10;

				} else {
					a = stack1.pop() + carry;
					b = stack2.pop();
					carry = (a + b) / 10;
					nam = (a + b) % 10;					
				}
				ans.push(nam);

			}
			if(carry == 1) ans.push(carry);
			System.out.print(String.format("#%d ", t));
			while(!ans.isEmpty()) {
				
				System.out.print(ans.pop());
			}
			System.out.println();

			
		}
		
		
	}
}