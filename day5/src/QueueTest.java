import java.util.LinkedList;

public class QueueTest {

	public static void main(String[] args) {
//		SQueue1 q = new SQueue1(5);
//		SQueue2 q = new SQueue2(5);
		
//		LinkedList<Character> q = new LinkedList<Character>();
//		System.out.println(q.isEmpty());
//		q.add('A');
//		q.add('B');
//		q.add('C');
//		System.out.println(q.isEmpty());
//		System.out.println(q.size());
//		System.out.println(q.poll());
//		System.out.println(q.peek());
//		q.add('D');
//		q.add('E');
//		System.out.println(q.peek());
//		q.add('F');
//		q.add('G');
//		System.out.println(q.size());
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		==============================================================
		
		SQueue3 q = new SQueue3();
		q.enQueue('A');
		q.enQueue('B');
		q.enQueue('C');
		
		System.out.println(q.size());
		System.out.println(q.deQueue());
		System.out.println(q.qPeek());
		q.enQueue('D');
		q.enQueue('E');
		System.out.println(q.qPeek());
		q.enQueue('F');
		q.enQueue('G');
		System.out.println(q.size());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		SQueue3.Node node = q.getFront();
		System.out.println("===================");
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
		
		
	}
}
