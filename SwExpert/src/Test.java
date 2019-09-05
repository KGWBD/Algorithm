import java.util.Collections;
import java.util.LinkedList;

public class Test {
	static LinkedList<Charger> list;
	static LinkedList<Charger> copiedList;
	public static void main(String[] args) {
		
		list = new LinkedList<>();
		copiedList = new LinkedList<>();
		
		list.add(new Charger(1,1,1,1));
		System.out.println(list.get(0));
		
		
		copiedList.addAll(list);
//		
//		System.out.println(copiedList.get(0));
		
		
	}
	
	static class Charger implements Comparable<Charger>{
		int x;
		int y;
		int coverage;
		int performance;
		public Charger(int x, int y, int coverage, int performance) {
			this.x = x;
			this.y = y;
			this.coverage = coverage;
			this.performance = performance;
		}
		@Override
		public int compareTo(Charger o) {
			return o.performance - performance;
		}
		@Override
		public String toString() {
			return super.toString();
		}
		
		
	}
}
