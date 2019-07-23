
public class SStack {
//데이터 저장 공간, 접근 위치
	char[] datas;
	
	int top= -1;
	int stackSize;
	
	public SStack() {
		stackSize=5;
		datas = new char[stackSize];
//		top = -1;
	}
	public int size() {
		return top + 1;
	}
	public char peek() {
		char ch = '\u0000';		//비어있는 값 , 공백도 글자
		if(isEmpty()) {
			System.out.println("stack is empty");
			return ch;
		}
		ch = datas[top];
		return ch;
	}
	
	public char pop() {
		char ch = '\u0000';		//비어있는 값 , 공백도 글자
		if(isEmpty()) {
			System.out.println("stack is empty");
			return ch;
		}
		ch = datas[top--];
		return ch;
	}
	
	public void push(char ch) {
		if(isFull()) {
			System.out.println("Stack is Full");
			return;
		}
		
		datas[++top] = ch;
	}
	
//	삽입, 삭제 , 꼭대기 확인, 비어있는지 판단, 꽉 차 있는지 판단.

	public boolean isFull() {
		if(top == stackSize-1) {
			return true;
		} else {
			return false;
		}
//		
	}
	public boolean isEmpty() {
//		if(top == -1) {
//			return true;
//		} else {
//			return false;
//		}
		
		return top == -1 ? true : false;
	}
	
//	
}
