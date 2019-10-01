import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2407 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[][] resultMap;
	static boolean[][] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		map = new int[N][N];
		resultMap = new int[N][N];
		sb = new StringBuilder();
		for(int i =0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0; i<N;i++) {
			dfs(i,i);
		}
		for(int i =0; i<N;i++) {
			for(int j = 0 ; j < N; j++) {
				sb.append(resultMap[i][j] + " ");
			}
			sb.append("\n");		
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int depth,int y) {
		
		for(int i =0; i<N; i++) {
			if(!visited[y][i] && map[depth][i]==1) {
				visited[y][i]=true;
				resultMap[y][i]=1;
				dfs(i,y);
			}
		}
		
	}
}
