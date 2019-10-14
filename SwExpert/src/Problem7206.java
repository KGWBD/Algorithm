import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem7206 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Set<String>[] set;
	static String input;
	static int dep;
	static int ans;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			set = new Set[99999+1];
			for(int i = 0; i < set.length; i++) {
				set[i] = new HashSet<>();
			}
			ans = 0;
			input = br.readLine();
			int dep = 0;
			set[dep].add(input);
			while(set[dep].size()!=0) {
				Iterator<String> it = set[dep].iterator();
				while(it.hasNext()) {
					dfs(0,"",it.next(),dep);
				}
				dep++;
			}
			bw.write("#"+t+" ");
			bw.write(ans + "\n");
		}
		bw.close();
	}

	private static void dfs(int depth, String string, String s, int cnt) {
		if (string.equals(s)) {
			if (ans < cnt)
				ans = cnt;
			return;
		}
		if (depth == s.length()) {
			st = new StringTokenizer(string," ");
			int multi = 1;
			while(st.hasMoreTokens()) {
				multi *= Integer.parseInt(st.nextToken());
			}
			set[cnt+1].add(String.valueOf(multi));
			return;
		}

		dfs(depth + 1, string + s.charAt(depth), s, cnt);
		if (depth != 0) {
			dfs(depth + 1, string + " " + s.charAt(depth), s, cnt);
		}
	}
	static class Pair{
		int cnt;
		String s;
		Pair(int cnt, String s){
			this.s = s;
			this.cnt =cnt;
		}
	}
}
