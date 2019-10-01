import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj2247 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static LinkedList<Pair> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		list = new LinkedList<>();
		for(int i = 0 ; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Pair(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken())));
		}
		Collections.sort(list);
		Long maxTerm1 = 0L;
		Long maxTerm2 = 0L;
		Long s1,e1,s2,e2;
		
		for(int i = 0; i<list.size();i++) {
			s1 = list.get(i).start;
			e1 = list.get(i).end;
			boolean flag = false;
			if(maxTerm1<e1-s1)maxTerm1=e1-s1;
			
			if((i<list.size()-1) && (maxTerm2<list.get(i+1).start-e1)) {
				maxTerm2=list.get(i+1).start-e1;
			}
			
			while(i+1 < list.size()&&e1>=list.get(i+1).start && e1<list.get(i+1).end) {
				e1 = list.get(i+1).end;
				if(maxTerm1<e1-s1)maxTerm1=e1-s1;
				i++;
				flag = true;
			}
			if(flag)i--;
		}
		
		
		
		
		
		System.out.println(maxTerm1 +" "+ maxTerm2);
		
		
		
		
		
		
		
		
		
		
	}
	static class Pair implements Comparable<Pair>{
		Long start;
		Long end;
		Pair(Long start,Long end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Pair o) {
			if(start==o.start) {
				return (int)(end-o.end);
			} else {
				return (int)(start-o.start);
			}
		}
		
		
	}
		

		
}
