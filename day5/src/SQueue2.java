//   원형 큐
public class SQueue2 {
	char[] datas;
	int front;
	int rear;
	int maxSize;

	public SQueue2(int maxSize) {
		front = rear = 0;
		this.maxSize = maxSize;
		datas = new char[maxSize];
	}

	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return (rear +1) % maxSize == front;
	}

	public char qPeek() {
		if (isEmpty()) {
			System.out.println("empty");
			return '\u0000';
		}
		int idx = (front + 1) % maxSize;
		return datas[idx];
	}

	public char deQueue() {
		if (isEmpty()) {
			System.out.println("empty");
			return '\u0000';
		}
		front = (front +1 ) % maxSize;
		return datas[front];
	}

	public void enQueue(char item) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		rear = (rear+1) %maxSize;
		datas[rear] = item;
		
	}
}
