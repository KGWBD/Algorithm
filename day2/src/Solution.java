

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int TEST_CASE = 10;
		int[] boxArr;
		int startIndex, endIndex;
		int maxIdx, minIdx;
		int dump_num, idx;
		
		
		for(int i = 1; i <= TEST_CASE;i++) {
			dump_num = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			boxArr = new int[st.countTokens()+1];
			while(st.hasMoreTokens()) {
				idx = Integer.parseInt(st.nextToken());
				boxArr[idx]++;
			}
			startIndex = 1;
			endIndex = 100;
			maxIdx = 0;
			minIdx = 0;
			for(int j=0;j<dump_num;j++) {
				
				while(boxArr[endIndex]<=0)endIndex--;
				while(boxArr[startIndex]<=0)startIndex++;


				boxArr[endIndex]--;
				boxArr[endIndex-1]++;
				boxArr[startIndex]--;
				boxArr[startIndex+1]++;
			}
			
			for(int j = 0; j < boxArr.length-1;j++) {
				if(boxArr[j]!=0) {
					minIdx=j;
					break;
				}
				
			}
			for(int j = boxArr.length-1; j >0;j--) {
				if(boxArr[j]!=0) {
					maxIdx=j;
					break;
				}
				
			}
		
			System.out.printf("#%d %d\n", i, (maxIdx-minIdx));
			
		}
		
	}
}
