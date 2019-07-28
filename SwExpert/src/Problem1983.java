import java.util.Arrays;
import java.util.Scanner;

public class Problem1983 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		String[] grades = { "A+","A0","A-","B+","B0","B-","C+","C0","C-","D0" };
		
		
		int studentNum = 0;
		int searchIndex = 0;
		int[] totalScores = null;
		int len = 0;
		int cnt;
		int searchStudnet = 0;
		
		for(int t = 1; t<=testCase;t++) {
			
			studentNum = sc.nextInt();
			searchIndex = sc.nextInt() - 1;
			
			totalScores = new int[studentNum];

			len = totalScores.length;
			for (int i = 0; i < len; i++) {
				
				totalScores[i] = sc.nextInt() * 35 + sc.nextInt() * 45 + sc.nextInt() * 20;

			}
			
			cnt = 0;
			searchStudnet = totalScores[searchIndex];
			for(int i = 0; i <len;i++) {
				if(searchStudnet<totalScores[i])cnt++;
			}
			
			if(cnt/10>=2) {
				cnt /= 2;
			}
			String result = grades[cnt];

			System.out.println("#"+t+" "+result);
	}
	}
}
