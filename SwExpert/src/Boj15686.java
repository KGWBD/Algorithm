import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj15686 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static boolean[] visited;
	static int[][] valueArr;
	static int N, M;
	static ArrayList<Position> homeList;
	static ArrayList<Position> storeList;
	static int homeSize;
	static int minDis = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		homeList = new ArrayList<Boj15686.Position>();
		storeList = new ArrayList<Boj15686.Position>();
		int input;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if (input == 1)
					homeList.add(new Position(i, j, 0));
				else if (input == 2)
					storeList.add(new Position(i, j, 0));
			}
		}
		visited = new boolean[storeList.size()];
		homeSize = homeList.size();
		powerSet(0, 0, storeList.size());

		System.out.println(minDis);
	}

	private static void powerSet(int depth, int cnt, int size) {
		if (depth == size && cnt != M)
			return;
		if (cnt == M) {
			LinkedList<Position> tempList = new LinkedList<Boj15686.Position>();
			Position home,store;
			for (int i = 0; i < size; i++) {
				if (visited[i]) {
					tempList.add(storeList.get(i));
				}
			} // 치킨집 고름 -> 이후에 이중포문을 돌면서 비교

			valueArr = new int[M][homeSize];
			
			for(int i = 0; i < M; i++) {
				store = tempList.get(i);
				for(int j = 0 ; j < homeSize; j++) {
					home = homeList.get(j);
					valueArr[i][j] = Math.abs(store.x-home.x) + Math.abs(store.y-home.y);
				}
			}
			int totalDis = 0;
			int dis;
			for(int i = 0 ; i <homeSize; i++) {
				 dis = Integer.MAX_VALUE;
				for(int j = 0 ; j <M; j++) {
					if(valueArr[j][i]<dis)dis = valueArr[j][i];
				}
				totalDis+=dis;
			}
			if(minDis>totalDis)minDis=totalDis;
			
			
			
			return;
		}

		visited[depth] = true;
		powerSet(depth + 1, cnt + 1, size);
		visited[depth] = false;
		powerSet(depth + 1, cnt, size);
	}



	static class Position {
		int y, x, dis;

		Position(int y, int x, int dis) {
			this.y = y;
			this.x = x;
			this.dis = dis;
		}

	}
}
