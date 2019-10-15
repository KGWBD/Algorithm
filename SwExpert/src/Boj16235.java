import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj16235 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, K;
	static LinkedList<Tree>[] list;
	static LinkedList<Tree> dyingTree;
	static int[][] ground;
	static int[][] food;
	static int[][] dirs = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ground = new int[N][N];
		food = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				food[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(ground[i], 5);
		} // 겨울에 추가될 양분 배열과 기본적인 땅의 양분배열생성
		int x, y, age;
		list = new LinkedList[1003];
		dyingTree = new LinkedList<>();
		for (int i = 0; i < 1003; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			age = Integer.parseInt(st.nextToken());
			list[0].add(new Tree(y - 1, x - 1, age));
		}
		int year = 0;
		while (year < K) {

			growUp(year);
			die();
			breeding(year + 1);
			feeding();
//			printGround();
			year++;
//			System.out.println(list[year].size());
		}
		bw.write(list[year].size() + "\n");
		bw.close();
	}


	
	private static void growUp(int year) {

		int size = list[year].size();
		int age, y, x;
		Tree temp;
		for (int i = 0; i < size; i++) {
			temp = list[year].poll();
			age = temp.age;
			y = temp.y;
			x = temp.x;

			if (age <= ground[y][x]) { // 양분을 먹을 수 있다.
				ground[y][x] -= age;
				temp.age += 1;
			} else { // 양분을 못먹어서 죽음.
				dyingTree.add(temp);
				age = 0;

			}
			if (age != 0) {
				list[year + 1].add(temp);
			}
		}

	}
	
	private static void die() {
		int size = dyingTree.size();
		Tree temp;
		for (int i = 0; i < size; i++) {
			temp = dyingTree.poll();
			ground[temp.y][temp.x] += temp.age / 2;
		}

	}
	private static void breeding(int year) {
		int size = list[year].size();
		int ny, nx;
		Tree temp;
		Iterator<Tree> it = list[year].iterator();
		ArrayList<Tree> tempList = new ArrayList<>();
		while (it.hasNext()) {
			temp = it.next();
			if (temp.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					ny = temp.y + dirs[i][0];
					nx = temp.x + dirs[i][1];

					if (!isRange(ny, nx))
						continue;

					tempList.add(new Tree(ny, nx, 1));
				}
			}
		}
		list[year].addAll(0,tempList);
	}

	

	private static void feeding() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ground[i][j] += food[i][j];
			}
		}
	}
	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == N)
			return false;
		return true;
	}

	private static void printGround() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(ground[i]));
		}
		System.out.println("==========================================");
	}

	private static void printFood() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(food[i]));
		}

	}

	static class Tree{
		int y, x, age;

		Tree(int y, int x, int age) {
			this.y = y;
			this.x = x;
			this.age = age;
		}
	}
}
