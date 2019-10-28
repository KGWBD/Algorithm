import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem5672 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			bw.write("#" + t + " ");
			N = Integer.parseInt(br.readLine().trim());
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				sb.append(br.readLine().trim());
			}

			arr = new char[N];
			arr = sb.toString().toCharArray();
			int start = 0, end = N - 1;

			while (start < end) {

				if (arr[start] < arr[end]) {
					bw.write(arr[start++]);
				} else if (arr[start] > arr[end]) {
					bw.write(arr[end--]);
				} else {
					int tempStart = start + 1;
					int tempEnd = end - 1;
					
					while (tempStart < tempEnd) {
						if (arr[tempStart] == arr[tempEnd]) {
							
//							System.out.println(" arr[tempStart] ::  "+arr[tempStart] + " arr[tempEnd] " + arr[tempEnd]);
							tempStart++;
							tempEnd--;
//							System.out.println("tempStart " + tempStart + " tempEnd ::" + tempEnd);
						} else {
							break;
						}
					}

					if (tempStart == tempEnd) {
						bw.write(arr[start++]);
						continue;
					} else if (tempStart > tempEnd) {
						bw.write(arr[end--]);
						continue;
					}

					if (arr[tempStart] < arr[tempEnd]) {
						bw.write(arr[start++]);
					} else if (arr[tempStart] > arr[tempEnd]) {
						bw.write(arr[end--]);
					}
				}
			}
			if(start==end) {
				bw.write(arr[end]);
			}

			bw.write("\n");
		}
		bw.close();
	}
}