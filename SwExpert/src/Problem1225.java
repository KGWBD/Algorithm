import java.util.LinkedList;
import java.util.Scanner;

public class Problem1225 {
	public static void main(String[] args) {
		LinkedList<Integer> list=null;
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			list = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				list.add(sc.nextInt());

			}
			int mok = list.get(0) / 15;
			for (int i = 0; i < list.size(); i++) {
				int newNum = list.poll() - (mok-1) * 15;
				list.add(newNum);
			}
			int cnt;
			int n = -1;
			outer: while (true) {
				cnt = 1;
				while (cnt <= 5) {
					n = list.poll() - cnt++;
					if (n <= 0) {
						list.add(0);
						break outer;
					}
					list.add(n);

				}

			}
			System.out.print("#"+t);
			for (int n1 : list) {
				System.out.print(" " +n1);
			}
			System.out.println();
		}
	}
}
