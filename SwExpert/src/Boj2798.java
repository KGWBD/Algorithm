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
		
		cards = new int[N];				//ī���� ������ŭ �迭����
		visited = new boolean[N];		//������ ������ �� �Ѱ����� ������ boolean �迭
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			cards[i] = Integer.parseInt(st.nextToken());	//card �� �ʱ�ȭ
		}
		ans = 0 ;
		powerSet(0,0,0);
		System.out.println(ans);
	}

	private static void powerSet(int depth,int sum,int cnt) {
		if(sum>M || (depth==N && cnt!=3)) {			//  ���� ī���� ���� �־��� ���ں��� ������ ���̻���� �ʿ� ���� ����;
			return;									//  depth�� N�϶� �����ϴµ� �Ѿ���� cnt �� ī���� ������ ������ 3�̸� �����ϸ� �ȵ�.
		}
		
		if(cnt==3) {								// ������ ī�尡 3�� ���
			int tmp = 0;
			for(int i = 0 ; i < N; i++) {
				if(visited[i]) {					// ������ ī�常 ���Ѵ�.
					tmp+= cards[i];
				}
			}
			if(tmp>M) {								// ���� �־��� ������ ũ�� ���ʿ����
				return;
			}
			
			if(ans<tmp) ans=tmp;					// �־��� �� �̸��� ī���� �ִ� ���ϴ� ����
			return;
		}
		// ���⼭ ���� �κ����� �˰���.. ������ ī�带 true�� ����� ������ ī���� ���� sum�� ��� �ѱ�  sum�� �־��� ���ں��� Ŭ ��� ������ �ٷ� ����.
		visited[depth] = true;
		sum += cards[depth];
		powerSet(depth+1,sum,cnt+1);
		sum -=cards[depth];
		visited[depth] = false;
		powerSet(depth+1,sum,cnt);
		
		/* �⺻���� �κ����� �˰���
		visited[depth] = true;
		powerSet(depth+1);
		visited[depth] = false;
		powerSet(depth+1);
 		
 		-> �̷��� ����� depth == �迭.length �϶� for���� ���鼭 ������ �͵鸸 ����
		 */
		
	}
}
