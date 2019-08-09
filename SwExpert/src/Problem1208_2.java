import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1208_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		
		for (int t = 1; t <= 10; t++) {
			int[] height = new int[101];
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				height[Integer.parseInt(st.nextToken())]++;
			}
			int start = 0;
			int end = height.length-1;
			while (dump >= 0  ) {

				while (height[start] == 0)
					++start;
				while (height[end] == 0)
					--end;
				if(start==end)break;
				height[end]--;
				height[start]--;
				height[end - 1]++;
				height[start + 1]++;
				
				dump--;
			}

			System.out.format("#%d %d\n", t, end - start);

		}

	}

}
