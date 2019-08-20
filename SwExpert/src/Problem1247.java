import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1247 {
	static Build office, home;
	static int dis;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			office = new Build(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Build(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			Build[] del = new Build[N];
			
			for (int i = 0; i < del.length; i++) {
				del[i] = new Build(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			dis = 987_654_321;
			permutation(del, 0);
			System.out.format("#%d %d\n", t, dis);

		} // tc

	}

	private static void permutation(Build[] del, int depth) {
		if (depth == del.length) {
			int tmp = 0;
			tmp = Math.abs(office.x - del[0].x) + Math.abs(office.y - del[0].y);
			tmp += Math.abs(home.x - del[del.length - 1].x) + Math.abs(home.y - del[del.length - 1].y);
			for (int i = 0; i < del.length - 1; i++) {
				tmp += Math.abs(del[i].x - del[i + 1].x) + Math.abs(del[i].y - del[i + 1].y);
			}

			if (dis > tmp) {
				dis = tmp;
			}
			return;
		}

		for (int i = depth; i < del.length; i++) {
			swap(del, depth, i);
			permutation(del, depth + 1);
			swap(del, depth, i);
		}

	}

	private static void swap(Build[] del, int depth, int i) {
		Build tmp = del[i];
		del[i] = del[depth];
		del[depth] = tmp;

	}
}

class Build {
	int x;
	int y;

	Build(int x, int y) {
		this.x = x;
		this.y = y;

	}
}