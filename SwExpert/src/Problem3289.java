import java.util.Scanner;

public class Problem3289 {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t<=tc;t++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			p = new int[N+1];

			makeSet();
			System.out.format("#%d ",t);
			for(int i = 0; i < M; i++) {
				
				int op = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(op==0) {
					unionSet(x,y);
				} else {
					x = findSet(x);
					y = findSet(y);
					if(x==y)System.out.print(1);
					else System.out.print(0);
						
				}
			}
			System.out.println();
		}//testCase
	}

	private static int findSet(int x) {
		if(x==p[x]) return x;
		int idx = findSet(p[x]);
		p[x] = idx;
		return idx;
	}

	private static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x!=y) {
			p[y] = x;
		}
		
		
	}

	private static void makeSet() {
		for(int i = 1 ; i < p.length; i++) {
			p[i] = i;
		}
	}
}
