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
		
		cards = new int[N];				//카드의 갯수만큼 배열생성
		visited = new boolean[N];		//선택한 것인지 안 한것인지 구분할 boolean 배열
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			cards[i] = Integer.parseInt(st.nextToken());	//card 값 초기화
		}
		ans = 0 ;
		powerSet(0,0,0);
		System.out.println(ans);
	}

	private static void powerSet(int depth,int sum,int cnt) {
		if(sum>M || (depth==N && cnt!=3)) {			//  만약 카드의 합이 주어진 숫자보다 높으면 더이상비교할 필요 없음 리턴;
			return;									//  depth가 N일때 리턴하는데 넘어오는 cnt 즉 카드의 선택한 갯수가 3이면 리턴하면 안됨.
		}
		
		if(cnt==3) {								// 선택한 카드가 3일 경우
			int tmp = 0;
			for(int i = 0 ; i < N; i++) {
				if(visited[i]) {					// 선택한 카드만 더한다.
					tmp+= cards[i];
				}
			}
			if(tmp>M) {								// 합이 주어진 값보다 크면 할필요없음
				return;
			}
			
			if(ans<tmp) ans=tmp;					// 주어진 값 미만의 카드중 최대 구하는 로직
			return;
		}
		// 여기서 부터 부분집합 알고리즘.. 선택한 카드를 true로 만들고 선택한 카드의 값을 sum에 담아 넘김  sum이 주어진 숫자보다 클 경우 위에서 바로 리턴.
		visited[depth] = true;
		sum += cards[depth];
		powerSet(depth+1,sum,cnt+1);
		sum -=cards[depth];
		visited[depth] = false;
		powerSet(depth+1,sum,cnt);
		
		/* 기본적인 부분집합 알고리즘
		visited[depth] = true;
		powerSet(depth+1);
		visited[depth] = false;
		powerSet(depth+1);
 		
 		-> 이렇게 만들고 depth == 배열.length 일때 for문을 돌면서 선택한 것들만 추출
		 */
		
	}
}
