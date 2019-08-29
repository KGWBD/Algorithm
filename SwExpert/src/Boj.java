import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Boj {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] tempa;
	static ArrayList<Mater> ma;
	static LinkedList<Mater> rem;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt(br.readLine());

		tempa = new int[10270];
		ma = new ArrayList<>();
		rem = new LinkedList<>();
		int cnt = 0;
		for (int j = 0; j < N; j++) {
			String s = br.readLine();
			int lowT = Integer.parseInt(s.split(" ")[0]) + 270;
			int highT = Integer.parseInt(s.split(" ")[1]) + 270;

			ma.add(new Mater(lowT, highT));
			for (int i = lowT; i <= highT; i++) { // 화확물질의 적정온도범위를 더해줘 화학물질이 가장 많이 겹치는 온도를 알고자 함.
				tempa[i]++;
			}
		}

		while (!ma.isEmpty()) { // 화학물질이 안 남을 시 냉장고도 필요하지 않기 때문에 반복문 빠져나감

			int max = 0;
			boolean flag = true;
			for (int i = 0; i < 10270; i++) { // 화확물질이 가장 많이 겹치는 곳부터 냉장고를 설치해주기 위해 많이 겹치는 곳의 온도를 찾음.
				if (tempa[max] < tempa[i]) {

					max = i;
					flag = false;
				}
			}
			if (flag) { // tempa 배열에 모든 데이터가 0이면 flag가 true고 그 때는 화학물질이 존재하지 않는 것이기에 밑에 과정을 처리하지 않고 냉장고
						// 횟수를 찍고 나간다.
				break;

			} else {

				Iterator<Mater> it = ma.iterator();
				while (it.hasNext()) { // 가장 많이겹치는 곳에 냉장고 설치
					Mater m = it.next();
					if (m.lowT <= max && m.highT >= max) {
						rem.add(m);

					}
				}
				int size = rem.size();

				for (int i = 0; i < size; i++) {
					Mater m = rem.poll();
					ma.remove(m);
					for (int j = m.lowT; j <= m.highT; j++) {
						tempa[j]--;
					}
				}

				cnt++;
			}
		}
		System.out.println(cnt);

	}

	static class Mater {
		int lowT;
		int highT;

		Mater(int lowT, int highT) {
			this.lowT = lowT;
			this.highT = highT;
		}
	}
}
