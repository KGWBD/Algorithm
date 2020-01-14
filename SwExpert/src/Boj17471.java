import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//ó�� ��� : ���ű��� �ΰ����� ������ -> powerSet���� ������ �׷�, �������� ���� �׷� �� �׷����� ������ �ڵ�.. ������ ����ó��
//		 :  ���ű��� ������ �ϳ��̻� ���ԵǾ�� �Ѵ�.  -> ��Ϳ� ������ ���� ���� ���ڰ����� �ѱ�鼭 depth�� �������� �� �Ǵ����ְ� ������ 0�̸� �ٷ� ����
//		 :  ���ʿ��� ������ ���δ� -> 123, 456 ���� ���� ���� 456, 123���� ���� �׷�� ������� ���⿡ ������ �׷���� ��ü ������ ������ ���� �� ���� ũ�� ����
//		 :  ������ �����Ѵ� -> unionSet���� ������ ���� ����Ǿ��ִٸ� �������ش�.
//		 :  �ο����� ���Ѵ� -> �� �������� ����Ű�� ���� 2���� ������ 2���� ���� ���� �� �� �ο��� üũ���ش�.
public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] section;
	static int[] p;
	static boolean[][] map;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		section = new int[N+1];
		map = new boolean[N + 1][N + 1];
		visited = new boolean[N];
		p = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			section[i+1] = Integer.parseInt(st.nextToken());
		}

		int num,next;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				next = Integer.parseInt(st.nextToken());
				map[i][next] = true;
				map[next][i] = true;
			}
		}

		powerSet(0, 0);
		ans= ans==Integer.MAX_VALUE?-1:ans;
		bw.write(ans + "\n");
		bw.close();
	}

	private static void powerSet(int depth, int cnt) {
		if (depth == N) {
			if (N / 2 < cnt || cnt == 0)
				return;
			List<Integer> firstSection = new ArrayList<Integer>();
			List<Integer> secondSection = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					firstSection.add(i+1);
				} else {
					secondSection.add(i+1);
				}
			}
			int now,next;
			makeSet();
			for(int i = 0; i < firstSection.size()-1; i++) {
				now = firstSection.get(i);
				for(int j = i+1 ; j < firstSection.size();j++) {
					next = firstSection.get(j);
					if(map[now][next])
					unionSet(now, next);
				}
			}
			
			for(int i = 0; i < secondSection.size()-1; i++) {
				now = secondSection.get(i);
				for(int j = i+1 ; j < secondSection.size();j++) {
					next = secondSection.get(j);
					if(map[now][next])
					unionSet(now, next);
				}
			}
			
			for(int i = 1; i<=N; i++) {
				findSet(i);
			}
			
			int sect = 0;
			for(int i = 1; i <=N; i++) {
				if(p[i]==i)sect++;
			}
			int peopelOfFirstSection = 0 ;
			int peopelOfSecondSection = 0;
			if(sect==2) {
				for(int i = 0 ; i < firstSection.size();i++) {
					peopelOfFirstSection+=section[firstSection.get(i)];
				}
				
				for(int i = 0 ; i < secondSection.size();i++) {
					peopelOfSecondSection+=section[secondSection.get(i)];
				}
				ans = Math.min(ans, Math.abs(peopelOfSecondSection-peopelOfFirstSection));
			}
			
			
			return;
		}
		visited[depth] = true;
		powerSet(depth + 1, cnt + 1);
		visited[depth] = false;
		powerSet(depth + 1, cnt);

	}


	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}

	private static int findSet(int x) {
		if (p[x] == x)
			return x;
		int px = findSet(p[x]);
		return p[x] = px;
	}
	
	private static void unionSet(int y,int x) {
		int py = findSet(y);
		int px = findSet(x);
		if(py!=px) {
			p[py] = px;
		}
	}

}
