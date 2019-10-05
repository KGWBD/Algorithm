import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N,M;
	static String[] words;
	static String[] moum = {"a","e","i","o","u"};
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		words = br.readLine().split(" ");
		Arrays.sort(words);
		dfs(0, "");
		
	}
	private static void dfs(int depth,String s) {
		if(depth==M) {
			if(s.length()==N) {
				int cnt = 0;
				for(int i = 0 ; i <moum.length;i++) {
					if(s.contains(moum[i]))cnt++;
				}
				if(cnt ==0 || cnt>M-2) {
					return;
				}
				System.out.println(s.trim());
			}
			return;
		}
		dfs(depth+1,s+words[depth]);
		dfs(depth+1,s);
		
	}

	
		
	
}
