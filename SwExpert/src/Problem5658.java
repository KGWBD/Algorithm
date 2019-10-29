import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem5658 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			Queue<Character> q = new LinkedList<Character>();
			Set<String> set = new HashSet<>();
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				q.offer(s.charAt(i));
			}
			String temp = "";
			int num = N / 4;
			int cnt = 0;
			int rotate = 0;
			while (rotate < num) {

				Iterator<Character> it = q.iterator();
				while (it.hasNext()) {
					temp += it.next();
					cnt++;
					if (cnt == num) {
						cnt = 0;
						set.add(temp);
						temp="";
					}
				}
				q.offer(q.poll());
				rotate++;
			}
			ArrayList<String> list = new ArrayList<>(set);
			Collections.sort(list);
			Collections.reverse(list);
			bw.write("#"+t+" ");
			bw.write(Integer.parseInt(list.get(K-1),16) + "\n");
		}
		bw.close();
	}
}
