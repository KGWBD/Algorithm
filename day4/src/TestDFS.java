public class TestDFS {
	public static void main(String[] args) {
		int[][] data = new int[7 +1][7 + 1];
		boolean[] checked = new boolean[7 + 1];
		
		data[1][2] = 1;
		data[2][1] = 1;
		
		data[3][1] = 1;
		data[1][3] = 1;
		
		data[2][4] = 1;
		data[4][2] = 1;
		
		data[2][5] = 1;
		data[5][2] = 1;
		
		data[3][5] = 1;
		data[5][3] = 1;
		
		data[4][6] = 1;
		data[6][4] = 1;
		
		data[5][6] = 1;
		data[6][5] = 1;
		
		data[7][6] = 1;
		data[6][7] = 1;
		dfs(data, checked, 1);
	}
	static char[] chars = {' ' , 'A','B','C','D','E','F','G'};
	static void dfs(int[][] data, boolean[] checked, int start) {
		checked[start] = true;
//		처리
		System.out.print(chars[start]+ " ");
		for(int i = 1; i < checked.length; i++) {
			if(!checked[i] && data[start][i] == 1) {
				dfs(data, checked, i);
			}
		}
		
	}
}
