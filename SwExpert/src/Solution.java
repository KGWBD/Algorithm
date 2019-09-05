import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i ++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int up = 0;
			int down = 0;
			
			for(int i = 0; i < N-1; i++) {
				int gap = arr[i] - arr[i+1];
				if(gap<0) {
					if(Math.abs(gap)>up) {
						up = Math.abs(gap);
					}
				} else {
					if(gap>down) {
						down = gap; 
					}
				}
			}
			System.out.format("#%d %d %d\n",t,up,down);
			
		}//testCase

	}
}
