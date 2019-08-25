import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem8382{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int tc = Integer.parseInt(br.readLine());
//		int tc = 1;
		for(int t = 1; t<= tc; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 =Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			x2 = Math.abs(x2 - x1);
			y2 = Math.abs(y2 - y1);
			x1 -= x1;
			y1 -= y1;
			
			
			boolean flag = Math.abs(x2-y2)>=2?true:false;
			if(x2<y2) {
				int tmp =x2;
				x2 = y2;
				y2 = tmp;
			}
			if(flag) {
				while(x2-y2>1) {
					y2+=2;
				}
			}
			System.out.format("#%d %d\n",t,x2+y2);
			
		}// testCase
	}
}