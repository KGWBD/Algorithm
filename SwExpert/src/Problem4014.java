import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem4014 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int N, X;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cur, next, cnt, cnt2;
			int j,i;
			outer: for (i = 0; i < N; i++) {
				boolean before = false;
				cur = map[i][0];
				cnt = 1;
				for (j = 0; j < N - 1; j++) {
					next = map[i][j + 1];
					if (cur == next) {
						cnt++;
					} else if (cur - 1 == next) {
						if(before) {
							if(cnt<X)continue outer;
						}
						cnt = 1;
						cur = next;
						before = true;
					} else if (cur == next - 1) {
						if(before) {
							if(cnt<2*X)continue outer;
						}
						if (cnt >= X) {
							cur = next;
							cnt = 1;
							before = false;
						} else {
							continue outer;
						}
					} else {
						continue outer;
					}
				}
				if(j==N-1) {
					if(before) {
						if(cnt>=X) {
							ans++;
//							System.out.println("i :: " + i);
						}
					} else {
//						System.out.println("i :: " + i);
						ans++;
					}
					
				}
			}
			
			outer: for (j = 0; j < N; j++) {
				boolean before = false;
				cur = map[0][j];
				cnt = 1;
				for (i = 0; i < N - 1; i++) {
					next = map[i+1][j];
					if (cur == next) {
						cnt++;
					} else if (cur - 1 == next) {
						if(before) {
							if(cnt<X)continue outer;
						}
						cnt = 1;
						cur = next;
						before = true;
					} else if (cur == next - 1) {
						if(before) {
							if(cnt<2*X)continue outer;
						}
						if (cnt >= X) {
							cur = next;
							cnt=1;
							before = false;
						} else {
							continue outer;
						}
					} else {
						continue outer;
					}
				}
				if(i==N-1) {
					if(before) {
						if(cnt>=X) {
							ans++;
//							System.out.println("j :: " + j);
						}
					} else {
//						System.out.println("j :: " + j);
						ans++;
					}
					
				}
			}
			
			bw.write("#"+t+" ");
			bw.write(ans+"\n");
		}
		bw.close();
	}
}
