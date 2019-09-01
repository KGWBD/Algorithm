import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, lowT, highT;
	static LinkedList<Pair> list;
	static LinkedList<Pair> removedList;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		list = new LinkedList<Main.Pair>();
		removedList = new LinkedList<Main.Pair>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lowT = Integer.parseInt(st.nextToken());
			highT = Integer.parseInt(st.nextToken());
			list.add(new Pair(lowT,highT));
		}
		Collections.sort(list);
//		for(Pair p:list) {
//			System.out.println(p.lowT);
//		}
		int cnt = 0;
		Pair cur = null;
		Pair next = null;
		while(!list.isEmpty()) {
//			System.out.println("=========================");
			cur = list.poll();
			cnt++;
			Iterator<Pair> it = list.iterator();
			int overLap =0;
			while(it.hasNext()) {
				next = it.next();
				if(next.highT<cur.highT) {
					if(removedList.size()>0) {
						cnt--;
					}
				}else if(next.lowT<=cur.highT) {
					removedList.add(next);
				} else if(next.lowT>cur.highT) {
					break;
				}
			}
			list.removeAll(removedList);
			removedList.clear();
			
//			for(Pair t:removedList) {
//				System.out.println("제거될 리스트"+t.lowT);
//			}
			
		}
		System.out.println(cnt);
		
	}

	static class Pair implements Comparable<Pair> {
		int lowT;
		int highT;

		Pair(int lowT, int highT) {
			this.lowT = lowT;
			this.highT = highT;
		}

		@Override
		public int compareTo(Pair o) {
			return lowT - o.lowT;
		}
		
		
		
	}
}
