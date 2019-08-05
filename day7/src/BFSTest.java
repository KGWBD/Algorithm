
public class BFSTest {

	public static void main(String[] args) {
		int[][] graph = new int[9+1][9+1];
		graph[1][2] = 1;
		graph[2][1] = 1;
		
		graph[3][1] = 1;
		graph[1][3] = 1;
		
		graph[4][1] = 1;
		graph[1][4] = 1;
		
		graph[2][5] = 1;
		graph[5][2] = 1;
		
		graph[2][6] = 1;
		graph[6][2] = 1;
		
		graph[4][7] = 1;
		graph[7][4] = 1;
		
		graph[4][8] = 1;
		graph[8][4] = 1;
		
		graph[4][9] = 1;
		graph[9][4] = 1;
		
		
		
	}

}
