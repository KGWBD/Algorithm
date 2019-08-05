
public class SQueue1 {
	char[] datas;
	int front;
	int rear;
	int maxSize;

	public SQueue1(int maxSize) {
		front = rear = -1;
		this.maxSize = maxSize;
		datas = new char[maxSize];
	}

	public int size() {
		return rear - front;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return rear == maxSize - 1;
	}

	public char qPeek() {
		if (isEmpty()) {
			System.out.println("empty");
			return '\u0000';
		}
		return datas[front + 1];
	}

	public char deQueue() {
		if (isEmpty()) {
			System.out.println("empty");
			return '\u0000';
		}
		return datas[++front];
	}

	public void enQueue(char item) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		datas[++rear] = item;
		
	}
}
