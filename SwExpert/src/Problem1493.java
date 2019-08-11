import java.util.ArrayList;
import java.util.Scanner;

public class Problem1493 {

	public static void main(String[] args) {
		Node node = null;
		Scanner sc = new Scanner(System.in);
		ArrayList<Node> list = null;

		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {

			list = new ArrayList<Node>();
			int x, y, n, p, sum, ans;
			for (int i = 0; i < 2; i++) {
				p = sc.nextInt();
				n = 0;
				sum = 0;

				while (p > sum) {
					n++;
					sum = n * (n + 1) / 2;
				}
				y = 1;
				x = n;

				while (sum != p) {
					y++;
					x--;
					sum--;
				}
				node = new Node(x, y);
				list.add(node);
			}
			x = 0;
			y = 0;
			for (Node n1 : list) {
				x += n1.x;
				y += n1.y;
			}

			n = x + y - 1;
			sum = n * (n + 1) / 2;
			ans = sum - (n - x);
			System.out.format("#%d %d\n",t,ans);
		}
	}
}

class Node {
	int x, y;

	Node() {
	}

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
