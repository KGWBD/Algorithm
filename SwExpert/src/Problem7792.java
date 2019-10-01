import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem7792 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Node[] list;
	static ArrayList<Node> result;
	static Set<Character> set;
	static int N;
	static int[] cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		
		for(int t=1; t<=T;t++) {
			
			N = Integer.parseInt(br.readLine());
			list = new Node[N];
			result = new ArrayList<Node>();
			cnt = new int[N];
			for(int i = 0 ;i<N; i++ ) {
				set = new HashSet<Character>();
				list[i] = new Node(br.readLine()); 
				for(int j=0;j<list[i].s.length();j++) {
					if(list[i].s.charAt(j)!=' ')set.add(list[i].s.charAt(j));
				}
				list[i].setIndex(set.size());
			}
			
			Arrays.sort(list);
			int max = list[0].index;
			for(int i = 0 ; i <N; i++) {
				if(max==list[i].index)result.add(list[i]);
			}
			Collections.sort(result);
			System.out.format("#%d %s\n",t,result.get(0).s);
			
			
			
		}	// testCase
		
	}
	static class Node implements Comparable<Node>{
		String s;
		int index;
		Node(String s){
			this.s = s;
		}
		void setIndex(int index){
			this.index = index;
		}
		@Override
		public int compareTo(Node o) {
			if(o.index==index) {
				return s.compareTo(o.s);
			} else {
				return o.index-index;
			}
		}
		
	}
		
}
