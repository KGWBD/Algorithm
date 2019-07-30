import java.util.Scanner;
import java.util.Stack;

public class Calcul {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> postfix = new Stack<Character>();
		Stack<Character> stack = new Stack<Character>();
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		char st = '\u0000';
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if ((ch >= '0') && (ch <= '9')) {
				postfix.push(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == '+' || ch == '-') {
				while (true) {
					st = stack.peek();
					if (st == '(') {
						stack.push(ch);
						break;
					} else {
						postfix.push(stack.pop());
					}
				}
			} else if (ch == '*' || ch == '/') {
				while (true) {
					st = stack.peek();
					if (st == '*' || st == '/') {
						postfix.push(stack.pop());
					} else {
						stack.push(ch);
						break;
					}

				}
			} else {
				while(true) {
					st = stack.peek();
					if(st=='(') {
						stack.pop();
						break;
					} else {
						postfix.push(stack.pop());
					}
					
					
				}
				
				
				
			}
			
		}
		String result = "";
		int size = postfix.size();
		for(int i = 0; i < size;i++) {
			result = postfix.pop() +result;
			
		}
		System.out.println(result);

			
		
	}
}
