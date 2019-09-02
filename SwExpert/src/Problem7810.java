import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem7810 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> list;
	static int N;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		
		for(int t=1; t<=T;t++) {
			
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			max = Integer.MIN_VALUE;
			for(int i = 0 ; i <N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list);
			int size = list.size();
			for(int h = 1; h<=N;h++) {
				if(size-h-1<0) {
					if(h<=list.get(size-h)) {
						max=h;	
					}
					break;
				}
				if(h<=list.get(size-h)) {
					if(max<h)max=h;
				}
			}
			System.out.format("#%d %d\n",t,max=max==Integer.MIN_VALUE?0:max);
			
			
			
			
			
			
			
			
		}//testCase
		
		
	}
}
