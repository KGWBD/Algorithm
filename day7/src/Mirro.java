
public class Mirro {
	static int[][] map;
	public static void main(String[] args) {
		map = new int[][]{  {0,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,1,1,0,1,1,1,1},
			{1,1,1,0,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,0,1,0,0,0,1,1},
			{1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0}
		};
		boolean[][] visited = new boolean[map.length][map.length];
//		flag = false;
		dfs(0,0,visited, 0);
		System.out.println(min == 99999999 ?"-1":min);
	}
	static int min = 99999999;
//	static boolean flag = true;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static void dfs(int x, int y, boolean[][] visited, int cnt) {
		//		종료, 실행, 자기호출
		if(cnt >= min) {
			return;
		}
		if(x == map.length-1 && y == map.length-1) {
//			flag = true;
			if(min > cnt) {
				min = cnt;
			}
			return;
		}
		int tx;
		int ty;
		for(int i = 0 ; i < 4; i++) {
			tx = x + dx[i];
			ty = y + dy[i];
			if(tx < 0 || tx >= map.length || ty < 0 || ty >= map.length){
				continue;
			}
			//			가지치기
			if( !visited[ty][tx] && map[ty][tx] == 0 ) {
				visited[ty][tx] = true;
				dfs(tx, ty, visited, cnt + 1);
				visited[ty][tx] = false;
			}
		} 

	}
}
















