import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSTest {
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		
		String str = "1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7";
		StringTokenizer st = new StringTokenizer(str);

		LinkedList<Integer>[] list = new LinkedList[8];
		boolean[] visited = new boolean[8];

		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<>();
		}
		while (st.hasMoreTokens()) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}

		
		
		bfs(list, visited, 1);
		
		

	}

	private static void bfs(LinkedList<Integer>[] list, boolean[] visited, int i) {
		
		visited[i] = true;
		queue.add(i);
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			System.out.println(idx);
			Iterator<Integer> it = list[idx].iterator();
			while(it.hasNext()) {
				int idx1 = it.next();
				if(!visited[idx1]) {
					visited[idx1] = true;
					queue.offer(idx1);
				}
			}
			
		}
		
		
		
		
		
	}
	
}
