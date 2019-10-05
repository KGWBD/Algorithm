	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.util.LinkedList;
	import java.util.Queue;
	
	public class Problem1249 {
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		static char[][] map;
		static int[][] timeArr;
		static int[][] valueArr;
		static int[] dx = {0,0,-1,1};
		static int[] dy = {-1,1,0,0};
		static int N;
	    public static void main(String[] args) throws NumberFormatException, IOException {
	    	int T = Integer.parseInt(br.readLine());
	//    	int T = 1;
	    	
	    	for(int t=1 ; t <= T; t++) {
	    		N = Integer.parseInt(br.readLine());
	    		map = new char[N][N];
	    		timeArr = new int[N][N];
	    		valueArr = new int[N][N];
	    		
	    		for(int i = 0 ; i < N ; i++) {
	    			map[i] = br.readLine().toCharArray();
	    		}
	    		for(int i = 0 ; i < N; i++) {
	    			for(int j = 0 ; j < N; j++) {
	    				timeArr[i][j] = map[i][j] - '0';
	    			}
	    		}
	    		
	    		searchShortLenght();
	    		
	    		bw.write("#"+t+" " );
	    		bw.write(valueArr[N-1][N-1]-1+"\n");
	    	}//testCase
	    	bw.close();
	    	
	    }
		private static void searchShortLenght() {
			
			Queue<Pair> q = new LinkedList<Pair>();
			q.offer(new Pair(0,0));
			valueArr[0][0] = 1;
			int ny,nx,nextVal;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				
				for(int i = 0 ; i < 4; i++) {
					
					ny = p.y + dy[i];
					nx = p.x + dx[i];
					
					if(!isRange(ny,nx))continue;
					
					nextVal = timeArr[ny][nx] + valueArr[p.y][p.x];
					
					if(valueArr[ny][nx]==0 || nextVal < valueArr[ny][nx]) {
						q.offer(new Pair(ny,nx));
						valueArr[ny][nx] = nextVal;
					}
					
					
				}
			}
			
			
		}
		
		static boolean isRange(int ny,int nx) {
			if(ny == N|| ny<0 ||nx==N||nx<0)return false;
			return true;
		}
		static class Pair{
			int y,x;
			Pair(int y, int x){
				this.y = y;
				this.x = x;
			}
		}
	 
	 
	 
	 
	}