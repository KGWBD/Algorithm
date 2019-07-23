
public class MyStack {

	char[] datas;
	int size;
	int top;
//	isfull,isempty, pop, push , peek;
	
	public MyStack() {
		datas = new char[100];
		size = datas.length;
		top = -1;
	}
	
	public boolean isEmpty() {
		return top == -1 ? true : false;
	}
	
	public boolean isFull() {
		return top == size-1 ? true : false;
	}
//	pop
	public char pop() {
		char data = '\u0000';
		if(isEmpty()) {
			System.out.println("Stack is empty");
			data = '\u0000';
		}
		data = datas[top--];
		return data;
	}
	
	public char peek() {
		char data = '\u0000';
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return '\u0000';
		}
		data = datas[top];
		return data;	
	}
	
	public void push(char item) {
		if(isFull()) {
			System.out.println("Stack is fulled");
			return;
		}
		
		datas[++top] = item;
		
	}
	
	public int size() {
		return size;
	}
	
	
//	public void check(String s) {
//		
//		boolean flag = true;
//		String[] srr = s.split("");
//		int stringSize = srr.length;
//		for(int i = 0; i < stringSize; i++) {
//			if("(".equals(srr[i])) {
//				push(srr[i]);
//				System.out.println(peek());
//			} else if(")".equals(srr[i])) {
//				String str = pop();
//				if("(".equals(str) ) {
//					flag = true;
//				} else {
//					System.out.println("Stack is Empty");
//					flag = false;
//					break;
//				} 
//				}
//			
//			}
//		
//		if(flag) {
//			System.out.println("검사이상없음");
//		} else {
//			System.out.println("검사이상");
//		}
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
}
