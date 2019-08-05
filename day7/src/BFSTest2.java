import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTest2 {

	public static void main(String[] args) {
		Graph graph = new Graph(9 + 1);
//		1,2;
		graph.addAdj(1,2);
		graph.addAdj(1,3);
		graph.addAdj(1,4);
		
		graph.addAdj(2,5);
		graph.addAdj(2,6);
		
		graph.addAdj(4,7);
		graph.addAdj(4,8);
		graph.addAdj(4,9);
		print(graph);
//		bfs(graph, 1);
		graph.bfs(1);
	}

	static char[] datas = {' ', 'A', 'B', 'C', 'D', 'E','F', 'G', 'H', 'I'};
	static boolean[] visited ;
	static void bfs(int[][] graph, int start) {

	}
	static class Graph{
		int ver;
		Queue<Integer>[]   adj = null;
		Graph(int ver){
			this.ver = ver;
			adj = new LinkedList[ver];
			for(int i =0; i < adj.length; i++) {
				adj[i] = new LinkedList();
			}
		}
		void bfs(int start) {
//			큐, 방문체크 배열
			boolean[] visited = new boolean[ver];
			Queue<Integer> q = new LinkedList<>();
			q.offer(start);
			while(!q.isEmpty()) {
				int idx = q.poll();
				System.out.print(datas[idx] + "");
				visited[idx] = true;
				Iterator<Integer> iterator = adj[idx].iterator();
				while(iterator.hasNext()) {
					idx = iterator.next();
					if(!visited[idx]) {
						q.offer(idx);
					}
				}
				
			}			
		}
		void addAdj(int x, int y) {
			adj[x].add(y);
		}
	}
	
	static void print(Graph g) {
		for (int i = 1; i < g.adj.length;i++) {
			System.out.println(i +"=>"+ g.adj[i]);
			
		}
	}

}







