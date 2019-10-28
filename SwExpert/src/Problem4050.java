import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem4050 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer> list;
	static int N;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(list, new Comparator<Integer>() {

				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			
			int sum = 0;
			int discount = 0;
			int temp;
			for(int i = 0 ; i < N ;i++) {
				temp = list.get(i);
				sum += temp;
				if(i%3==2) {
					discount+= temp;
				}
			}
			
			System.out.format("#%d %d\n",t,sum-discount);
			
		}
		
		
	}

}
