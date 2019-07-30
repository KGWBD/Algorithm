import java.util.Stack;

public class example {
	public static void main(String[] args) {
		String str = "6528-*2/+";
		Stack<Integer> stack = new Stack<Integer>();
		char[] chars = str.toCharArray();
		char ch = '\u0000';
		int num1,num2,num3;
		for(int i =0; i<str.length();i++) {
			ch = chars[i];
			if(ch >='0' && ch <= '9') {
				stack.push(ch-'0');
			} else {
				num2= stack.pop();
				num1 = stack.pop();
				num3 = calc(ch,num1,num2);
				stack.push(num3);
				
			}
		}
		
		System.out.println(stack.pop());
		
		
	}

	private static int calc(char ch, int num1, int num2) {
		int result = 0;
		switch(ch) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		}
		return result;
	}
}
