import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj1157 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String ans = "";
	static String[] sArr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	public static void main(String[] args) throws IOException {
		int[] arr = new int[26];
		String s = br.readLine().toLowerCase();
		
		for(int i = 0 ; i < s.length();i++) {
			arr[s.charAt(i)-'a']++;
		}
		
		int max = 0;
		int maxIdx = 0;
		for(int i = 0 ; i < 26; i++) {
			if(max<arr[i]) {
				max = arr[i];
				maxIdx = i;
			}
		}
		int cnt = 0;
		for(int i = 0 ; i < 26; i++) {
			if(max==arr[i])cnt++;
			if(cnt>1) {
				ans = "?";
				break;
			}
		}
		if(!ans.equals("?")) {
			ans=sArr[maxIdx];
		}
		System.out.println(ans);
		
	}
	
}
