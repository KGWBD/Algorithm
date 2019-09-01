import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17413 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		sb = new StringBuilder();
		String in = br.readLine();
		boolean flag = false;
		for(int i = 0 ; i < in.length();i++) {
			char tmp = in.charAt(i);
			
			if(tmp=='<') {
				if(sb.toString().length()!=0) {
					System.out.print(sb.reverse().toString());
					sb = new StringBuilder();
				}
				flag = true;
			}
			if(tmp==' ') {
				if(sb.toString().length()!=0) {
					System.out.print(sb.reverse().toString());
					sb = new StringBuilder();
				}
				System.out.print(" ");
				continue;
			}
			
			if(flag) {
				System.out.print(tmp);
				if(tmp=='>')flag = false;
			} else {
				sb.append(tmp);
			}
		}
		if(sb.toString().length()!=0) {
			System.out.print(sb.reverse().toString());
		}
		
	}
}
