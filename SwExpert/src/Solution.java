import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] comp = {"a","e","i","o","u"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		
		for(int t=1; t<=T;t++) {
			
			String s = br.readLine();
			
			for(int i = 0; i<comp.length;i++) {
				s = s.replaceAll(comp[i], "");
			}
			System.out.println(s);
			
			
			
			
			
			
			
			
			
			
			
			
		}	// testCase
		
	}
		
}
