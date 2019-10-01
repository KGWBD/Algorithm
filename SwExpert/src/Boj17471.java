import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj17471 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> firstSection;
	static ArrayList<Integer> secondSection;
	static int[] population;
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int[] p;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		population = new int[N+1];
		map = new int[N+1][N+1];
		p = new int[N+1];
		visited = new boolean[N+1];
		st = new StringTokenizer(br.readLine().trim());
		for(int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			int tmp = Integer.parseInt(st.nextToken());
			for(int k=0;k<tmp;k++) {
				int j = Integer.parseInt(st.nextToken());
				map[i][j] = 1;
				map[j][i] = 1;
			}
		}
		
		garryMendering(1);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
//		printArr();
		
		
	}

	private static void garryMendering(int depth) {
		if(depth==N+1) {
			firstSection = new ArrayList<Integer>();
			secondSection = new ArrayList<Integer>();
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(visited[i]) {
					firstSection.add(i);
					cnt++;
				} else {
					secondSection.add(i);
				}
			}
			
			if(cnt!=0&&cnt!=N) {	// 구역 확실히 나눔
				makeSet();
				int section1,section2;
				for(int i = 0 ; i <firstSection.size();i++) {
					section1 = firstSection.get(i);
					for(int j = 0; j<firstSection.size();j++) {
						section2 = firstSection.get(j);
						if(map[section1][section2]==1) {
							unionSet(section1, section2);
						}
					}
				}
				for(int i = 0 ; i <secondSection.size();i++) {
					section1 = secondSection.get(i);
					for(int j = 0; j<secondSection.size();j++) {
						section2 = secondSection.get(j);
						if(map[section1][section2]==1) {
							unionSet(section1, section2);
						}
					}
				}
				for(int i = 1; i<=N;i++) {
					findSet(i);
				}
				int sectionNum = 0;
				for(int i = 1; i <=N;i++) {
					if(p[i]==i)sectionNum++;
				}
				if(sectionNum==2) {
					int sum1,sum2;
					sum1 = sum2 = 0;
					for(int i = 0 ; i<firstSection.size();i++) {
						sum1 += population[firstSection.get(i)];
					}
					for(int i = 0 ; i<secondSection.size();i++) {
						sum2 += population[secondSection.get(i)];
					}
					int num = Math.abs(sum1-sum2);
					if(min>num)min=num;
				}//sectionNum==2
			}
			return;
		}
		
		visited[depth] = true;
		garryMendering(depth+1);
		visited[depth] = false;
		garryMendering(depth+1);
		
		
	}

	private static void makeSet() {
		for(int i = 1; i <=N;i++) {
			p[i] = i;
		}
	}
	
	private static int findSet(int x) {
		if(p[x]==x)return x;
		int idx = findSet(p[x]);
		return p[x] = idx;
	}
	
	private static boolean unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px!=py) {
			p[px] = py;
			return true;
		}
		return false;
	}
	
	private static void printArr() {
		for(int i = 1; i <=N; i++) {
			for(int j = 1 ; j<=N;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
		
}
