import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Boj1235 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Set<String> set;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		set = new HashSet<>();
		for(int i = 0 ; i < N; i++) {
			arr[i] = br.readLine();
		}
		Long n = 10L;
		int len = 1;
		int length = arr[0].length();
		for(int l = length-1; l>=0 ;l--) {
			for (int i = 0; i < N; i++) {
				String temp = arr[i].substring(l,length);
				if (!set.add(temp)) {
					set.clear();
					break;
				}
			}
			if(set.size()==N) {
				len = l;
				break;
			}
		}
		System.out.println(length-len);
	}
}
