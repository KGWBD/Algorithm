import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static LinkedList<String>[] list;
	static Set<String> set;
	static int N;
	static int[] cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
//		int T = Integer.parseInt(br.readLine());
		int T = 1;
		
		for(int t=1; t<=T;t++) {
			
			N = Integer.parseInt(br.readLine());
			list = new LinkedList[N];
			set = new HashSet<String>();
			cnt = new int[N];
			for(int i = 0 ;i<N; i++ ) {
				list[i] = new LinkedList<String>();
				st = new StringTokenizer(br.readLine()," ");
				while(st.hasMoreTokens()) {
					list[i].add(st.nextToken());
				}
			}
			
			
			
			
			
			
		}	// testCase
		
	}
		
}
