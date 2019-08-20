import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Nqueen {
	static Set<Integer> set = new HashSet<>();
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {

			int N = sc.nextInt();

			int[] board = new int[N];
			cnt=0;
			dfs(board, 0);
			System.out.format("#%d %d\n",t,cnt);
		}
	}

	private static void dfs(int[] board, int depth) {
		if (depth == board.length) {
			cnt++;
			return;
		}

		for (int i = 0; i < board.length; i++) {

			if (set.add(i)) {
				board[depth] = i;
				if (isPromising(board, depth)) {
					dfs(board, depth + 1);
					set.remove(i);
				} else {
					board[depth] = 0;
					set.remove(i);
				}

			}
		}

	}

	private static boolean isPromising(int[] board, int depth) {
		for (int i = 0; i < depth; i++) {
			boolean flag = Math.abs(board[i] - board[depth]) == Math.abs(i - depth);
			if (flag) {
				return false;
			}
		}

		return true;
	}
}
