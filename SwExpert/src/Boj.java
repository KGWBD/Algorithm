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
			for (int i = lowT; i <= highT; i++) { // ȭȮ������ �����µ������� ������ ȭ�й����� ���� ���� ��ġ�� �µ��� �˰��� ��.
				tempa[i]++;
			}
		}

		while (!ma.isEmpty()) { // ȭ�й����� �� ���� �� ����� �ʿ����� �ʱ� ������ �ݺ��� ��������

			int max = 0;
			boolean flag = true;
			for (int i = 0; i < 10270; i++) { // ȭȮ������ ���� ���� ��ġ�� ������ ����� ��ġ���ֱ� ���� ���� ��ġ�� ���� �µ��� ã��.
				if (tempa[max] < tempa[i]) {

					max = i;
					flag = false;
				}
			}
			if (flag) { // tempa �迭�� ��� �����Ͱ� 0�̸� flag�� true�� �� ���� ȭ�й����� �������� �ʴ� ���̱⿡ �ؿ� ������ ó������ �ʰ� �����
						// Ƚ���� ��� ������.
				break;

			} else {

				Iterator<Mater> it = ma.iterator();
				while (it.hasNext()) { // ���� ���̰�ġ�� ���� ����� ��ġ
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
