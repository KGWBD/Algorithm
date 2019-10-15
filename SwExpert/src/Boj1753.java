import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1753 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Node>[] map;
	static int[] dist;
	static int nV, nE, K;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		nV = Integer.parseInt(st.nextToken());
		nE = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		map = new ArrayList[nV + 1];
		for (int i = 1; i < nV + 1; i++) {
			map[i] = new ArrayList<>();
		}
		
		int now, next, value;
		for (int i = 0; i < nE; i++) {
			st = new StringTokenizer(br.readLine());
			now = Integer.parseInt(st.nextToken());
			next = Integer.parseInt(st.nextToken());
			value = Integer.parseInt(st.nextToken());
			map[now].add(new Node(next,value));
		}
		
		dist = new int[nV + 1];
		Arrays.fill(dist, INF);
		dijstra(K);
		
		for (int i = 1; i <= nV; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				bw.write("INF\n");
			else
				bw.write(dist[i] + "\n");
		}
		bw.close();

	}

	private static void dijstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start, dist[start]));
		Node now, next;
		int size = 0;
		while (!pq.isEmpty()) {
			now = pq.poll();
			
			size = map[now.index].size();
			for (int i = 0; i < size; i++) {
				next = map[now.index].get(i);

				if (dist[next.index] > dist[now.index] + next.value) {
					dist[next.index] = dist[now.index] + next.value;
					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int index, value;

		Node(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return value - o.value;
		}

		@Override
		public String toString() {
			return "Node [index=" + index + ", value=" + value + "]";
		}

	}

}
