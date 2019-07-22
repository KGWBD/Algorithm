package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HomeWork1 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int maxScore = 100;
		
		int[] counts = null;
		int idx;
		int max,maxIndex;
		
		StringTokenizer st = null;
		
		String testNum,str = "";
		
		for(int i = 1; i <= testCase; i++) {
			max  = -1;
			maxIndex = -1;
			counts = new int[maxScore+1];
			testNum = br.readLine();
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			
			while(st.hasMoreTokens()) {
				idx = Integer.parseInt(st.nextToken());
				counts[idx]++;
			}
			
			System.out.println(Arrays.toString(counts));
			
			for(int j=0; j<counts.length;j++) {
				if( max < counts[j]) {
					max = counts[j];
					maxIndex = j;
					
				}
			}
			
			System.out.printf("#%d %d\n", i, maxIndex);
			
			
			
			
		}
		
		
		
		
	}
}
