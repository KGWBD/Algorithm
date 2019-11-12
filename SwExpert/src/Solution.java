import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][][] map;
	static int[] p;
	static Set<String> set;
	static boolean[] checked;
	static int[][] dir = { // 3차원 방향 h, y ,x
			{ 0, -1, 0 }, // 상 하 좌우 위 아래
			{ 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 1, 0, 0 }, { -1, 0, 0 } };
	static int ans = Integer.MAX_VALUE;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		map = new int[5][5][5];
		p = new int[5];
		checked = new boolean[5];
		set = new HashSet<>();
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 5; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		permutation(0);
		System.out.println(ans);
	}

	private static void permutation(int depth) {
		if (depth == 5) {
			// 처리
//			String temp = "";
//			for (int i = 0; i < 5; i++) {
//				temp += p[i];
//			}
//			if (set.add(temp)) { // 이제 오른쪽으로 돌리면서 나올수 있는지 체크;
			System.out.println(Arrays.toString(p));
				int[][][] tempMap = new int[5][5][5];
				int[][][] rotatedMap = new int[5][5][5];
				for (int k = 0; k < 5; k++) {
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							tempMap[k][i][j] = map[p[k]][i][j];
							rotatedMap[k][i][j] = map[p[k]][i][j];
						}
					}
				} // 아직 돌리진 않음..
				
				
				for (int k = 0; k < 5; k++) {
					for (int r = 0; r < 4; r++) {
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								rotatedMap[k][j][5 - i - 1] = tempMap[k][i][j];
							}
						}
						
						for(int i = 0 ; i < 5 ; i++) {
							for(int j = 0 ; j < 5 ;j++) {
								tempMap[k][i][j] = rotatedMap[k][i][j];
							}
						}
						printMap(tempMap);			
						bfs(tempMap);
						
					}
				}

				// 처리가 끝나고 반대로 하는 경우는 막아준다.
//				temp = "";
//				for (int i = 4; i >= 0; i--) { // 반대로 돌리는 건 의미없다. 그걸 막아주기 위해서
//					temp += p[i];
//				}
//				set.add(temp);
//			} else {
//				return;
//			}
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (!checked[i]) {
				checked[i] = true;
				p[depth] = i;
				permutation(depth + 1);
				checked[i] = false;
			}
		}

	}

	private static void printMap(int[][][] tempMap) {
		for(int k = 0 ; k < 5 ;k++) {
			for(int i = 0; i < 5 ; i++) {
				System.out.println(Arrays.toString(tempMap[k][i]));
			}
			System.out.println("---------------------------");
			
		}
		System.out.println("============================================================================");
		
	}

	private static void bfs(int[][][] tempMap) {
		boolean[][][] visited = new boolean[5][5][5];
		visited[0][0][0] = true;
		Queue<Position> q = new LinkedList<Solution.Position>();
		q.offer(new Position(0,0,0,0));
		int ny,nx,nh;
		Position pos;
		while(!q.isEmpty()) {
			pos = q.poll();
			if(ans<=pos.cnt)return;
			
			if(pos.h==4 && pos.y ==4 && pos.x==4) {
				if(ans>pos.cnt+1)ans=pos.cnt;
				System.exit(0);
				System.out.println(pos);
				return;
			}
			for(int i = 0; i < 6; i++) {
				nh = pos.h + dir[i][0];
				ny = pos.y + dir[i][1];
				nx = pos.x + dir[i][2];
				if(!isRange(nh,ny,nx))continue;
				
				if(!visited[nh][ny][nx] && tempMap[nh][ny][nx]==1) {
					visited[nh][ny][nx] = true;
					q.offer(new Position(nh,ny,nx,pos.cnt+1));
				}
			}
			
			
			
		}
	}
	
	private static boolean isRange(int nh, int ny, int nx) {
		if(nh <0 || ny<0 || nx<0 || nh==5|| ny==5||nx==5)return false;
		return true;
	}

	static class Position{
		int h,y,x,cnt;
		Position(int h, int y, int x,int cnt){
			this.h = h;
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Position [h=" + h + ", y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}
		
		
	}
}
