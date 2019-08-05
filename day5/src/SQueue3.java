public class SQueue3 {
	
	Node front;
	Node rear;
	int size;
	
	public Node getFront() {
		return front;
	}
	
	public char qPeek() {
		if(isEmpty()) {
			System.out.println("empty");
			return '\u0000';
		}
		char data = front.data;
		return data;
		
	}
	
	public char deQueue() {
		if(isEmpty()) {
			System.out.println("empty");
			return '\u0000';
		}
		char data = front.data;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		size--;
		return data;
		
		
		
	}
	public void enQueue(char item) {
		Node node = new Node();
		node.data = item;
//		node.next = null; 초기값이 널이기 때문에 생략가능
		if(front==null) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
		size++;
	}
	public int size() {
		return size;
		
	}
	
	public boolean isEmpty() {
		return front == null && rear == null;
	}
	class Node{
		char data;
		Node next;
	}
}
