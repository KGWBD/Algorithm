import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<Number>[] circle;
	static StringTokenizer st;
	static int N, M, T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N���� ����
		M = Integer.parseInt(st.nextToken()); // M�� ��
		T = Integer.parseInt(st.nextToken()); // �ݺ� Ƚ��

		circle = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++) {
			circle[i] = new LinkedList<>();
		}
		int numberCnt = 0;
		int sum = 0;
		int n = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				n = Integer.parseInt(st.nextToken());
				circle[i].add(new Number(n));
			}
		}
		System.out.println("sum :: " + sum);
		System.out.println("numberCnt :: " + numberCnt);
		int x, d, k;
//		printCircle();
//		System.out.println("===============================");
		while (T > 0) { // �ݺ��� Ƚ��....
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); // x�� ��� ������
			d = Integer.parseInt(st.nextToken()); // ���� 0 �ð� 1 �ݽð�
			k = Integer.parseInt(st.nextToken()); // 1ĭ ������ 2ĭ������

			for (int i = 1; i <= N; i++) {
				if (i % x == 0) { // ���� ���ǵ� ������. �ð�������� �ƴ��� �Ǵ��� �ݺ�
					switch (d) {
					case 0: // �ð�
						for (int j = 0; j < k; j++) {
							circle[i].addFirst(circle[i].pollLast());
						}
						break;
					case 1:
						for (int j = 0; j < k; j++) {
							circle[i].addLast(circle[i].pollFirst());
						}
						break;
					}

				}
			}
//			System.out.println(T);
			printCircle();
			System.out.println("==================");
			Number temp, rigth, down, up;
			Set<Number> tempList = new HashSet<>();
			for (int i = 1; i <= N; i++) { // ����
				for (int j = 0; j < M; j++) {
					if (j == 0) {
						temp = circle[i].getFirst();
						if (temp.num != -1) {
							rigth = circle[i].get(1);
							if (temp.num == rigth.num) {
								tempList.add(rigth);
								tempList.add(temp);
							}
						}
					} else if (j == M - 1) {
						temp = circle[i].getLast();
						if (temp.num != -1) {
							rigth = circle[i].getFirst();
							if (temp.num == rigth.num) {
								tempList.add(rigth);
								tempList.add(temp);
							}
						}
					} else {
						temp = circle[i].get(j);
						if (temp.num != -1) {
							rigth = circle[i].get(j + 1);
							if (temp.num == rigth.num) {
								tempList.add(rigth);
								tempList.add(temp);
							}
						}
					}
				}
			} // ���� �����鼭 �����Ѱ��� ������
			
			for (int j = 0; j < M; j++) {
				for (int i = 1; i <= N; i++) {
					if (i == N) {
						temp = circle[i].get(j);
						if (temp.num != -1) {
							down = circle[i - 1].get(j);
							if (temp.num == down.num) {
								tempList.add(down);
								tempList.add(temp);
							}
						}
					} else {
						temp = circle[i].get(j);
						if (temp.num != -1) {
							up = circle[i + 1].get(j);
							if (temp.num == up.num) {
								tempList.add(up);
								tempList.add(temp);
							}
						}
					}
				}
			}
			
			if (tempList.size() > 0) {
				Iterator<Number> it = tempList.iterator();
				System.out.println(tempList.size());
				while (it.hasNext()) {
					temp = it.next();
					temp.num = -1;
				}
				
				System.out.println("*****************************");
				printCircle();
				System.out.println("*****************************");
				System.out.println("sum :: " + sum);
				
			} else {
				sum = 0;
				numberCnt = 0;
				for(int i = 1; i<=N; i++) {
					for(Number b : circle[i]) {
						if(b.num!=-1) {
							sum+=b.num;
							numberCnt++;
						}
					}
				}
				
				double average = (double) sum / numberCnt;
				for (int i = 1; i <= N; i++) {
					Iterator<Number> it = circle[i].iterator();
					while (it.hasNext()) {
						temp = it.next();
						if(temp.num>average ) {
							temp.num -=1;
						} else if(temp.num<average && temp.num!=-1){
							temp.num+=1;
						}
					}
				}
				
				for(int i = 1; i<=N; i++) {
					for(Number b : circle[i]) {
						if(b.num!=-1) {
							sum+=b.num;
						}
					}
				}
				System.out.println("*****************************");
				printCircle();
				System.out.println("*****************************");
				System.out.println("sum :: " + sum);
			}
			T--;
		}
		
		bw.write(sum + "\n");
		bw.close();

	}

	static class Number {
		int num;

		Number(int num) {
			this.num = num;
		}

	}

	private static void printCircle() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(circle[i].get(j).num + " ");
			}
			System.out.println();
		}

	}

}
