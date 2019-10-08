import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj17143 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R, C, M;
	static int ans;
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		LinkedList<Node> list = new LinkedList<Node>();
		LinkedList<Node> removeList = new LinkedList<Node>();
		int r, c, s, d, z;
		int num = r = c = s = d = z = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			list.add(new Node(r, c, s, d, z));
		}

		while (num < C) { // 1번째..
				Collections.sort(list);
				Node remove = null;
				for (Node n : list) {
					if (n.c == num + 1) {
						ans += n.z;
						remove = n;
						break;
					}
				} // 같은 열에 있는 상어중 땅과 가장 가까운 상어 제거. ok
				if(remove!=null) list.remove(remove);
				

				move(num, list);
				
				int size = list.size();
				for (int i = 0; i < size - 1; i++) {
					Node now = list.get(i);
					for (int j = i + 1; j < size; j++) {
						Node next = list.get(j);
						if (now.c == next.c && now.r == next.r) {
							if (now.z > next.z) {
								removeList.add(next);
							} else {
								removeList.add(now);
							}
						}
					}
				} // 잡아 먹음
				list.removeAll(removeList);
				removeList.clear();
			num++; // 오른쪽으로 이동;
		}
		bw.write(ans + "\n");
		bw.close();
	}

	private static void move(int num, LinkedList<Node> list) {
		int dir = 0;
		int speed = 0;
		int ny, nx, tempY, tempX;
		ny = nx = tempY = tempX = 0;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			Node n = list.get(i);
			dir = n.d; // 방향 얻음
			speed = n.s;
			tempY = n.r;
			tempX = n.c;
			if(dir==1 || dir==2)speed = speed%((R-1)*2);
			else speed = speed%((C-1)*2);
			while (speed > 0) {
				ny = tempY + dy[dir];
				nx = tempX + dx[dir];
				if (!isRange(ny, nx)) {
					dir = chageDirection(dir);
					ny = tempY + dy[dir];
					nx = tempX + dx[dir];
				}

				tempY = ny;
				tempX = nx;
				speed--;
			}
//			list.addLast(new Node(tempY, tempX, n.s, dir, n.z));
			n.r = tempY;
			n.c = tempX;
			n.d = dir;
		}

	}

	private static int chageDirection(int dir) {
		int newDir = 0;
		switch (dir) {
		case 1:
			newDir = 2;
			break;
		case 2:
			newDir = 1;
			break;
		case 3:
			newDir = 4;
			break;
		case 4:
			newDir = 3;
			break;
		}

		return newDir;
	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 1 || ny == R + 1 || nx < 1 || nx == C + 1)
			return false;
		return true;
	}

	static class Node implements Comparable<Node> {
		int r, c, s, d, z;

		Node(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Node o) {
			return r - o.r;
		}

	}

}