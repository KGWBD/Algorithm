import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFSTest {
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

		
		
		dfs(list, visited, 1);
		
		

	}

	private static void dfs(LinkedList<Integer>[] list, boolean[] visited, int i) {
		
		visited[i] = true;
		System.out.println(i);
		
		Iterator<Integer> it = list[i].iterator();
		
		while(it.hasNext()) {
			int idx = it.next();
			if(!visited[idx]) {
				dfs(list,visited,idx);
			}
			
		}
		
		
			
	}

}
