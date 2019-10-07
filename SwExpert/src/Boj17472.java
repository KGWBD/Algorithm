import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17472 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int N, M;
	static int[] p;
	static boolean[][] visited;
	static ArrayList<Pair>[] list;
	static ArrayList<Node> nodes;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nodes = new ArrayList<>();
		map = new int[N][M];
		visited = new boolean[N][M];
		p = new int[8];
		list = new ArrayList[8];
		for (int i = 0; i < 8; i++) {
			list[i] = new ArrayList<>();
		}
		int islandNum = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j, islandNum);
					islandNum++;	//5
				}
			}
		} // for : outer;
		
		for (int i = 1; i < islandNum-1; i++) {	//1부터 4까지 있으면 1~3의 섬
			for (int j = 0; j < list[i].size(); j++) {
				Pair p1 = list[i].get(j);	//첫번째 섬의 모든 좌표
				for (int k = i + 1; k < islandNum; k++) { //앞 섬보다 하나 앞선, 선택정렬느낌
					int minDis = Integer.MAX_VALUE;
					for (int q = 0; q < list[k].size(); q++) {
						Pair p2 = list[k].get(q);
						int dis = getBridge(i, k, p1, p2);
//						System.out.println(dis);
						if(dis<=1)continue;
						if(minDis>dis)minDis=dis;
					}
					if(minDis!=Integer.MAX_VALUE) {
//						System.out.print(i +" "+k);
//						System.out.println();
						nodes.add(new Node(i,k,minDis));
					}

				}
			}
		}
		Collections.sort(nodes);
		makeSet();
		int totalDis = 0;
		for (Node n : nodes) {
//			System.out.println(n);
			if (unionSet(n.now, n.next)) {
				totalDis += n.distance;
			}
		}
		for(int i = 1; i<islandNum;i++) {
			findSet(p[i]);
		}
		int cnt = 0;
		for(int i = 1; i < islandNum;i++) {
			if(p[i]==i) {
				cnt++;
			}
		}
		if(totalDis==0||cnt>=2)totalDis=-1;
		System.out.println(totalDis);

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
	}

	private static int getBridge(int now, int next, Pair p1, Pair p2) {
		int dis = Integer.MAX_VALUE;
		if(p1.x==p2.x) {
			for(int i = Math.min(p1.y, p2.y)+1; i<Math.max(p1.y, p2.y);i++) {
				if(map[i][p1.x]!=0) {
					return dis;
				}
			}
			return Math.abs(p1.y-p2.y)-1;
		} else if(p1.y == p2.y) {
			for(int i = Math.min(p1.x, p2.x)+1; i<Math.max(p1.x, p2.x);i++) {
				if(map[p1.y][i]!=0) {
					return dis;
				}
			}
			return Math.abs(p1.x-p2.x)-1;
		}
		return dis;
	}
			

	private static void bfs(int y, int x, int islandNum) {
		Queue<Pair> q = new LinkedList<>();
		visited[y][x] = true;
		map[y][x] = islandNum;
		list[islandNum].add(new Pair(y, x));
		q.offer(new Pair(y, x));
		int ny, nx;
		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				ny = p.y + dy[i];
				nx = p.x + dx[i];

				if (!isRange(ny, nx))
					continue;

				if (!visited[ny][nx] && map[ny][nx] == 1) {
					visited[ny][nx] = true;
					map[ny][nx] = islandNum;
					q.offer(new Pair(ny, nx));
					list[islandNum].add(new Pair(ny, nx));
				}
			}
		}
	}

	private static void makeSet() {
		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}
	}

	private static int findSet(int x) {
		if (p[x] == x)
			return x;
		int idx = findSet(p[x]);
		return p[x] = idx;
	}

	private static boolean unionSet(int y, int x) {
		int px = findSet(x);
		int py = findSet(y);
		if (px != py) {
			p[px] = py;
			return true;
		}
		return false;
	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == M)
			return false;
		return true;
	}

	static class Pair {
		int y;
		int x;

		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Pair [y=" + y + ", x=" + x + "]";
		}
	}

	static class Node implements Comparable<Node> {
		int now;
		int next;
		int distance;

		Node(int now, int next, int distance) {
			this.now = now;
			this.next = next;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return distance - o.distance;
		}

		@Override
		public String toString() {
			return "Node [now=" + now + ", next=" + next + ", distance=" + distance + "]";
		}

	}
}
