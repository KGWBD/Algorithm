import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4408 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		int tc = Integer.parseInt(br.readLine().trim());
//		int tc = 1;
		for (int t = 1; t <= tc; t++) {

			int N = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[201];

			for (int i = 0; i < N; i++) {

				String s = br.readLine().trim();
				int start = Integer.parseInt(s.split(" ")[0]);
				int end = Integer.parseInt(s.split(" ")[1]);
				if(start>end) {
					int tmp = start;
					start = end;
					end = tmp;
				}
				if (start % 2 != 0)start += 1;
				if (end % 2 != 0)end += 1;

				start /= 2;
				end /= 2;
				for (int j = start; j <= end; j++) {
					arr[j]++;
				}	
			}
			int max =0;
			for(int i=0; i<arr.length;i++) {
				if(max<arr[i]) {
					max = arr[i];
				}
			}
			System.out.format("#%d %d\n",t,max);
		}
	}

}
