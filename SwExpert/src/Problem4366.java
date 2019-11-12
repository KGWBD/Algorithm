import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem4366 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Set<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] arr = br.readLine().split("");//1010
			String[] arr2 = br.readLine().split("");//212
			String temp;
			String s = "";
			set = new HashSet<>();
			for (int i = 0; i < arr.length; i++) {
				temp = arr[i];
				if (temp.equals("0"))
					arr[i] = "1";
				else
					arr[i] = "0";
				s = "";
				for (int j = 0; j < arr.length; j++) {
					s += arr[j];  //0010  1110 1000 1011
				}
				set.add(Integer.parseInt(s, 2));
				arr[i] = temp;
			}
			
			for(int i = 0 ; i < arr2.length; i++) {
				temp = arr2[i];
				for(int j = 0 ; j < 3; j++) { //112
					s="";
					if(temp.equals(""+j))continue;
					arr2[i]=""+j;
					
					for(int k = 0 ; k < arr2.length;k++) {
						s+=arr2[k];
					}
					
					if(!set.add(Integer.parseInt(s,3))) {
						bw.write("#"+t+" ");
						bw.write(Integer.parseInt(s,3)+"\n");
					}
					
				}
				
				
				arr2[i]=temp;
			}
		}
		bw.close();
	}
}
