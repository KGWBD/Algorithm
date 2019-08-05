import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) {
		
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		int mizzu = 20;
		int mizzuz = 1;
		int personNum = 1;
		int cnt = 1;
		q.add(personNum);
		int num=1;
		while(mizzu>0) {
			if(cnt%2==0) {
				num = (int)q.peek();
				q.poll();
				mizzu -= ++mizzuz;
				q.add(num);
				q.add(++personNum);
				
			} else {
				num = (int)q.peek();
				q.poll();
				mizzu--;
				q.add(num);
				q.add(++personNum);
			}
			cnt++;
			
		}
		System.out.println(num);
		
		
		
		
		
	}
	
}
