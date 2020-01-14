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

//처음 사고 : 선거구를 두가지로 나눈다 -> powerSet으로 선택한 그룹, 선택하지 않은 그룹 두 그룹으로 나누는 코드.. 나누면 다음처리
//		 :  선거구에 지역이 하나이상 포함되어야 한다.  -> 재귀에 선택한 구역 수를 인자값으로 넘기면서 depth가 마지막일 때 판단해주고 구역이 0이면 바로 리턴
//		 :  불필요한 실행을 줄인다 -> 123, 456 으로 나눈 경우는 456, 123으로 나눈 그룹과 결과값이 같기에 선택한 그룹수가 전체 지역을 반으로 나눈 수 보다 크면 리턴
//		 :  지역을 연결한다 -> unionSet으로 지역이 서로 연결되어있다면 연결해준다.
//		 :  인원수를 구한다 -> 각 지역들이 가리키는 값이 2개면 구역이 2개로 나눈 경우라서 그 때 인원을 체크해준다.
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
