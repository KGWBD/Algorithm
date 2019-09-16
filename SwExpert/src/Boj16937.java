import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16937 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int H,W,N;
	static Pair[] arr;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		arr = new Pair[N];
		visited = new boolean[N];
		
		int R,C;	
		for(int i = 0 ; i <N ; i++ ) {
			st = new StringTokenizer(br.readLine());
			R =  Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(R,C);
		}
		combi(0,0);
		System.out.println(max==Integer.MIN_VALUE?0:max);
	}
	
	private static void combi(int depth,int cnt) {
		if(depth==N && cnt!=2)return;
		if(cnt == 2) {
			int checkCnt=0;
			int sum=0;
			Pair[] sticker = new Pair[2];
			for(int i = 0; i < N;i++) {
				if(visited[i] && check(i)) {
					sum+=arr[i].c*arr[i].r;
					sticker[checkCnt] = arr[i];
					checkCnt++;
					
				}
			}
			if(checkCnt<2)return;
			else {
				if(sum>H*W) return;
				else if(check(sticker)){
					if(max<sum)max = sum;
				}
			}
			
			
			//처리
			return;
		}
		
		
		visited[depth] = true;
		combi(depth+1,cnt+1);
		visited[depth] = false;
		combi(depth+1,cnt);
		
		
	}


	private static boolean check(Pair[] sticker) {
		int row = sticker[0].c+sticker[1].c;
		int col = Math.max(sticker[0].r, sticker[1].r);
		if((row<=H && col<=W) || (row<=W && col<=H)) {
			return true;
		} 
		row = sticker[0].r+sticker[1].c;
		col = Math.max(sticker[0].c, sticker[1].r);
		if((row<=H && col<=W) || (row<=W && col<=H)) {
			return true;
		}
		row = sticker[0].r+sticker[1].r;
		col = Math.max(sticker[0].c, sticker[1].c);
		if((row<=H && col<=W) || (row<=W && col<=H)) {
			return true;
		}
		row = sticker[0].c+sticker[1].r;
		col = Math.max(sticker[0].r, sticker[1].c);
		if((row<=H && col<=W) || (row<=W && col<=H)) {
			return true;
		}
		
		return false;
	}

	private static boolean check(int i) {
		Pair p = arr[i];
		if(Math.max(p.c, p.r)>Math.max(H, W)) {
			return false;
		}
		return true;
	}


	static class Pair{
		int r;
		int c;
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
