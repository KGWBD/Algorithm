
public class DisJoinSetTest {
	static int[] p;
	static int max = 10;

	public static void main(String[] args) {

		p = new int[max];
		makeSet();
		unionSet(0, 1);

	}

	static int findSet(int x) {
		if(x == p[x])return x;
		int idx = findSet(p[x]);
		p[x] = idx;
		return idx; 
	}

	private static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (x != y)
			p[y] = x;
	}

	private static void makeSet() {
		for (int i = 0; i < p.length; i++) {
			p[i] = i;

		}
	}
}
