import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem1221 {
	static LinkedList<String>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {

			list = new LinkedList[10];
			for (int i = 0; i < 10; i++) {
				list[i] = new LinkedList<String>();
			}

			st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			int n = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			String tmp;
			while (st.hasMoreTokens()) {
				tmp = st.nextToken();
				switch (tmp) {
				case "ZRO":
					list[0].add(tmp);
					break;
				case "ONE":
					list[1].add(tmp);
					break;
				case "TWO":
					list[2].add(tmp);
					break;
				case "THR":
					list[3].add(tmp);
					break;
				case "FOR":
					list[4].add(tmp);
					break;
				case "FIV":
					list[5].add(tmp);
					break;
				case "SIX":
					list[6].add(tmp);
					break;
				case "SVN":
					list[7].add(tmp);
					break;
				case "EGT":
					list[8].add(tmp);
					break;
				case "NIN":
					list[9].add(tmp);
					break;
				}
			}
			System.out.println(c);
			for (int i = 0; i < 10; i++) {
				while (!list[i].isEmpty()) {
					System.out.print(list[i].poll() + " ");
				}
			}
		}

	}
}
