import java.util.Scanner;

public class Main {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int cnt;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int row = sc.nextInt();
		int col = sc.nextInt();
		sc.nextLine();

		String[][] arr = new String[row][col];
		visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			arr[i] = sc.nextLine().split("");
		}

		dfs(arr, 0, 0, "");
		System.out.println(cnt);
	}

	private static void dfs(String[][] arr, int y, int x, String str) {
		str += arr[y][x];
		boolean canbe=false;
		
		int ty, tx;
		for (int i = 0; i < 4; i++) {
			ty = y + dy[i];
			tx = x + dx[i];
			if (ty < 0 || ty == arr.length || tx < 0 || tx == arr[0].length) {
				continue;
			}
			if (!visited[ty][tx] && !str.contains(arr[ty][tx])) {
				canbe=true;
				visited[y][x] = true;
				dfs(arr, ty, tx, str);
				visited[y][x] = false;
			}
			
		}
		
		if(canbe==false) {
			//갱신
			if(cnt<str.length()) {
				cnt=str.length(); //현재 내 위치
			}
		}

	}
}
