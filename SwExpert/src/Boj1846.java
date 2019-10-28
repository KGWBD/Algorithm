import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Boj1846 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> colList;
	static boolean flag;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		if (N == 3) {
			bw.write(-1 + "\n");
		} else if (N % 2 == 0) {
			bw.write(N / 2 + "\n");
			for (int i = 1; i < N / 2; i++) {
				bw.write(i + "\n");
			}
			for (int i = N/2+2;  i <=N; i++) {
				bw.write(i+"\n");
			}
			bw.write(N/2+1+"\n");
		} else if(N%2==1) {
			bw.write(N / 2 + 1 + "\n");
			for(int i = 1; i<N/2+1;i++) {
				bw.write(i+"\n");
			}
//			
			for(int i=N/2+3;i<=N;i++) {
				bw.write(i+"\n");
			}
			bw.write(N/2+2+"\n");
		}
		bw.close();
	}

}