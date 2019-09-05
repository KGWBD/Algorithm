import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1258 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Problem1258.Bottle> list;
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		
		for(int t=1; t<=T;t++) {
			
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			map = new int[N][N];
			list = new ArrayList<>();
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0 ; i < N; i ++) {
				for(int j = 0 ; j < N ; j++) {
					if(map[i][j]!=0) {
//						System.out.println("i::" + i + "j::"+j);
						checkCam(i,j);
					}
				}
			}
			Collections.sort(list);
			System.out.format("#%d %d ",t,list.size());
			for(Bottle b : list) {
				System.out.print(b.row + " " + b.col + " ");
			}
			System.out.println();
			}
		}	// testCase
		
	private static void checkCam(int y, int x) {
		int row = -1;
		int col = -1;
		int i=y;
		int j=x;
		for(i = y ; i < N; i++) {
			if(map[i][x]==0) {
				row = i;
				break;
			}
			for(j = x; j < N; j++) {
				if(map[i][j]!=0) {
					map[i][j]=0;
				} else if(map[i][j]==0) {
					col = j;
					break;
				}
			}
		}
		if(row==-1)row=i;
		if(col==-1)col=j;
		row -=y;
		col -=x;
		list.add(new Bottle(row, col, row*col));
//		for(i = 0 ; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}
	static class Bottle implements Comparable<Bottle>{
		int row;
		int col;
		int size;
		Bottle(int row, int col, int size){
			this.row = row;
			this.col = col;
			this.size = size;
		}
		@Override
		public int compareTo(Bottle o) {
			if(size == o.size) {
				return row - o.row;
			} else {
				return size - o.size;
			}
			
					
		}
		
	}
}
