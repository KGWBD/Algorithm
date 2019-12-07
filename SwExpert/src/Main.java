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
	static int[] perm;
	static int[][] hitter;
	static int N;
	static boolean[] visited;
	static int max_ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[9];
		perm = new int[9];
		hitter = new int[N][9];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9 ; j++) {
				hitter[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		permu(0);
		
		System.out.println(max_ans);
	}
	private static void permu(int depth) {
		if(depth==3) {
			permu(depth+1);
			return;
		}
	
		if(depth==9) {
			int hitterIdx = 0; //주자를 기억하는 변수
			int score = 0;
			int temp;
			outer:for(int i = 0 ; i < N ; i ++) {//이닝
				int out = 0;
				boolean[] person = new boolean[4];
				while(true) {
					for(int j = hitterIdx ; j < 9 ; j++) {
						temp = hitter[i][perm[j]];//1,2,3,4,0
						
						if(temp==4)score++;
						
						if(temp==0) {
							out++;
							if(out>2) {
								hitterIdx = (j+1)%9;
								continue outer;
							}// 주자 기억하고 다음이닝 시작
							continue;//다음 타석 들어섬					
						} else{
							for(int k=3;k>0;k--) { //3루부터 판단
								if(person[k]) {	//출루한 주자있다면
									if(k+temp>=4) {
										score++;
										person[k] = false;
									} else {
										person[k] = false;
										person[k+temp] = true;
									}
								} //없다면
							}//3루부터 판단
							
							if(temp<4)person[temp]=true;
						}
					}
					hitterIdx=0;
				}
			}
			
			if(max_ans<score)max_ans=score;
			
			
			return;
		}
		
		
		for(int i = 1 ; i < 9 ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				perm[depth] = i;
				permu(depth+1);
				visited[i] = false;
			}
		}
	}
}