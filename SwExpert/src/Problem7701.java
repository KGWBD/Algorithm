import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Problem7701 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static Set<String> set;
	static LinkedList<String>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ;t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			set = new HashSet<>();
			int maxLength = 0;
			for(int i = 0 ; i < N; i++) {
				String s = br.readLine();
				set.add(s);
				if(maxLength<s.length())maxLength=s.length();
			}
			
			list = new LinkedList[maxLength+1];
			for(int i = 1; i <= maxLength; i++) {
				list[i] = new LinkedList<String>();
			}
			
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String temp = it.next();
				list[temp.length()].add(temp);
			}
			
			bw.write("#" + t + "\n");
			for(int i = 1; i<= maxLength; i++) {
				Collections.sort(list[i]);
				for(int j = 0 ; j < list[i].size(); j++) {
					bw.write(list[i].get(j) + " \n");
				}
			}
		}
		bw.close();
	}
}
