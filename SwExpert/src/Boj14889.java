import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj14889 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static boolean[] visited;
	static int N;	
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		powerSet(0,0);
		System.out.println(min);
	}

	private static void powerSet(int depth,int cnt) {
		if(depth==N && cnt!=N/2)return;
		if(cnt==N/2) {
			ArrayList<Integer> firstTeam = new ArrayList<>();
			ArrayList<Integer> secondTeam = new ArrayList<>();
			for(int i = 0 ; i < N; i++) {
				if(visited[i]) {
					firstTeam.add(i);
				} else {
					secondTeam.add(i);	
				}
			}//팀나누기
			
			int sum1 = 0, sum2 = 0;
			int f1,f2,s1,s2;
			for(int i = 0 ; i < N/2-1; i++) {
				f1 = firstTeam.get(i);
				s1 = secondTeam.get(i);
				for(int j = i+1; j < N/2; j++) {
					f2 = firstTeam.get(j);
					s2 = secondTeam.get(j);
					sum1 += map[f1][f2] + map[f2][f1];
					sum2 += map[s1][s2] + map[s2][s1];
				}
			}
			if(min>Math.abs(sum1-sum2))min=Math.abs(sum1-sum2);
			return;
		}
		visited[depth] = true;
		powerSet(depth+1, cnt+1);
		visited[depth] = false;
		powerSet(depth+1, cnt);
	
	}
}
