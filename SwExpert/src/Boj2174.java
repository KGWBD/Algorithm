import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Boj2174 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static int[][] lobotId;
	static ArrayList<Lobot> list;
	static int[] dx = { 0, 1, 0, -1 }; // 시계방향
	static int[] dy = { -1, 0, 1, 0 };
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		lobotId = new int[N][M];
		list = new ArrayList<Boj2174.Lobot>();
		st = new StringTokenizer(br.readLine());
		int init = Integer.parseInt(st.nextToken());
		int order = Integer.parseInt(st.nextToken());
		
		int y,x,dir;
		for(int i = 1 ; i <= init; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			dir = getDirection(String.valueOf(st.nextElement()));
			lobotId[N-1-(y-1)][x-1] = i;
			list.add(new Lobot(N-1-(y-1), x-1, i, dir));
		}

		int id,cycle;
		String orderCase;
		
		for(int i = 0 ; i < order; i++) {
			
			st = new StringTokenizer(br.readLine());
			id = Integer.parseInt(st.nextToken());
			orderCase = String.valueOf(st.nextToken());
			cycle = Integer.parseInt(st.nextToken());
			
			work(id,orderCase,cycle);
			if(flag)break;
		}
		if(!flag) {
			bw.write("OK" + "\n");
		}
		bw.close();
		
	}

	private static void work(int id, String orderCase, int cycle) throws IOException {
		Iterator<Lobot> it = list.iterator();
		Lobot lobot = null;
		while(it.hasNext()) {
			lobot = it.next();
			if(id==lobot.id) {
				break;
			}
		}
		int ny,nx;
		switch(orderCase) {
		case "L":
			while(cycle>0) {
				lobot.dir = lobot.dir-1;
				if(lobot.dir<0)lobot.dir=3;
//				System.out.println(lobot);
				cycle--;
			}
			break;
		case "R":
			while(cycle>0) {
				lobot.dir = (lobot.dir+1)%4;
				cycle--;
			}
			break;
		case "F":
			while(cycle>0) {
				ny = lobot.y + dy[lobot.dir];
				nx = lobot.x + dx[lobot.dir];
				
				if(!isRange(ny,nx)) {
					flag = true;
					bw.write("Robot "+ lobot.id + " crashes into the wall"+"\n" );
					return;
				}
				
				if(lobotId[ny][nx]!=0) {
					flag = true;
					bw.write("Robot " + lobot.id+ " crashes into robot " + lobotId[ny][nx] + "\n");
					return;
				}
				
				lobotId[lobot.y][lobot.x] = 0;
				lobot.y = ny;
				lobot.x = nx;
				lobotId[ny][nx] = lobot.id;
//				System.out.println(lobot);
//				System.out.println(cycle);
//				for(int i = 0 ; i < N ; i++) {
//					System.out.println(Arrays.toString(lobotId[i]));
//				}
				cycle--;
			}
		}
		
		
		
	}

	private static boolean isRange(int ny, int nx) {
		if(ny <0 || ny == N || nx < 0 || nx== M)return false;
		return true;
	}

	private static int getDirection(String dir) {
		switch (dir) {
		case "N":
			return 0;
		case "S":
			return 2;
		case "W":
			return 3;
		case "E":
			return 1;
		}
		return 0;
	}

	static class Lobot {
		int id, dir, x, y;

		Lobot(int y, int x, int id, int dir) {
			this.id = id;
			this.dir = dir;
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Lobot [id=" + id + ", dir=" + dir + ", x=" + x + ", y=" + y + "]";
		}
		
	}
}
