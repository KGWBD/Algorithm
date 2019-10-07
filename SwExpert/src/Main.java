import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] arr;
	static StringBuilder ans;

	public static void main(String[] args) throws IOException {
		ans = new StringBuilder();
		outer:for (int t = 1; t <= 4; t++) {

			st = new StringTokenizer(br.readLine());
			int N = 6;
			int M = 3;
			arr = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			int mid = 0;
			int cnt = 0;
			int win = 0;
			int lose = 0;
			for(int i = 0 ; i < N; i++) {
				int sum = arr[i][0] + arr[i][1] + arr[i][2];
				if(sum!=5) {
					ans.append("0 ");
					continue outer;
				}
				win += arr[i][0];
				mid += arr[i][1];
				
				lose += arr[i][2];
				if(arr[i][1]!=0)cnt++;
			}
			if (cnt % 2 != 0) {
				ans.append("0 ");
				continue outer;
			}
			
			if(win+mid/2!=15 || lose+mid/2!=15) {
				ans.append("0 ");
				continue outer;
			}
			
			ans.append("1 ");
		}
		System.out.println(ans.toString().trim());
	}

}
