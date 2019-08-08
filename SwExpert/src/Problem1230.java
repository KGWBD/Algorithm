package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem1230 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<String> list = new LinkedList<>();
		StringTokenizer st = null;
		for (int t = 1; t <= 10; t++) {

			int originN = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}

			int orderN = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			String order = null;
			int x = 0;
			int y = 0;
			for (int i = 0; i < orderN; i++) {
				order = st.nextToken();
				if (order.equals("I")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					insert(st, list, x, y);
				}

				else if (order.equals("D")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					delete(st, list, x, y);
				} else {
					y = Integer.parseInt(st.nextToken());
					add(st, list, y);
				}
			}

			System.out.print("#"+t);
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
		}
	}

	private static void add(StringTokenizer st, LinkedList<String> list, int y) {
		for (int i = 0; i < y; i++) {
			list.add(st.nextToken());
		}
	}

	private static void delete(StringTokenizer st, LinkedList<String> list, int x, int y) {
		for (int i = 0; i < y; i++) {
			list.remove(x);
		}

	}

	private static void insert(StringTokenizer st, LinkedList<String> list, int x, int y) {
		for (int i = 0; i < y; i++) {
			list.add(x + i, st.nextToken());
		}
	}

}
