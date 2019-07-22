import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2007 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int repeatNum;
		int startIdx ,endIdx ,interval;
		for(int i = 1;i<=testCase; i++) {
			String str = br.readLine();
			interval = 2;
			startIdx = 0;
			repeatNum = 1;
			endIdx = startIdx + interval;
			while(endIdx<str.length()) {
				
				System.out.println("startIdx" + startIdx);
				System.out.println("endIdx"+endIdx);
				System.out.println("str.substring(startIdx,endIdx)" + str.substring(startIdx,endIdx));
				System.out.println("str.substring(startIdx+interval, endIdx+interval)" +str.substring(startIdx+interval, endIdx+interval));
				System.out.println("interval"+interval);
				System.out.println("------------------------");
				
				if(str.substring(startIdx,endIdx).equals(str.substring(startIdx+interval, endIdx+interval))) {
					startIdx += interval;
					endIdx += interval;
					repeatNum++;
					if(repeatNum>2)break;
				} else {
					interval++;
					startIdx = 0;
					endIdx = startIdx + interval;
				}
				
			}
			System.out.printf("#%d %d",i,interval);
		}
		
	}
}
