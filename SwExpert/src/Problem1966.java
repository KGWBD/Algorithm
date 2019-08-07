import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1966 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		ArrayList<Integer> list;
		StringBuilder sb;
		int testCase = sc.nextInt();
		

		for (int t = 1; t <= testCase; t++) {
			sb = new StringBuilder();
			list = new ArrayList<Integer>();
			
			int num = sc.nextInt();
			sc.nextLine();
			st = new StringTokenizer(sc.nextLine(), " ");
		
			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
				
			Collections.sort(list);
			

			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i) + " ");
			}

			System.out.format("#%d %s\n", t, sb.toString().trim());
		}
	}
}
