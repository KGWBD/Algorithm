import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2798 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] cards;
	static boolean[] visited;
	static StringTokenizer st;
	static int N,M;
	static int ans;
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cards = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0 ;
		powerSet(0,0,0);
		System.out.println(ans);
	}

	private static void powerSet(int depth,int sum,int cnt) {
		if(sum>M || (depth==N && cnt!=3)) {
			return;
		}
		
		if(cnt==3) {
			int tmp = 0;
			for(int i = 0 ; i < N; i++) {
				if(visited[i]) {
					tmp+= cards[i];
				}
			}
			if(tmp>M) {
				return;
			}
			
			if(ans<tmp) ans=tmp;
			return;
		}
		visited[depth] = true;
		sum += cards[depth];
		powerSet(depth+1,sum,cnt+1);
		sum -=cards[depth];
		visited[depth] = false;
		powerSet(depth+1,sum,cnt);
		
		
	}
}
