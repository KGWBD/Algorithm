import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem4013 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static LinkedList<Integer>[] list;
	static int K;
	static int[] dirs;
	static boolean[] canRotate;
	static int dir;
	static int idx;
	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
//		int T = 1;

		for (int t = 1; t <= T; t++) {
			
			K = Integer.parseInt(br.readLine());		//�ڼ��� ȸ����Ű�� ����
			list = new LinkedList[4];					//�鴵�� Į���� ��ũ�� ����Ʈ������
			
			for(int i = 0 ; i < 4; i++) {
				list[i] = new LinkedList<Integer>();	//�鴵 ����
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					list[i].add(Integer.parseInt(st.nextToken())); //��� �ʱ�ȭ
				}
			}
			
			
			for(int i=0; i<K;i++) {
				st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken()) -1;		//���° ��ϸ� ȸ�� ��ų ������.
				dir = Integer.parseInt(st.nextToken());			//�ð���� 1, �ݽð� ���� -1
				dirs = new int[4];								//���� ����� ������ ������
				dirs[idx] = dir;
				canRotate = new boolean[4];						//�ºپ� �ִ� ��ϰ� �η��� �߻��ϴ���.
				canRotate[idx] = true;							//���� ��ϴ� ��������
				int temp = idx;									
				while(temp<3) {
					dirs[temp+1] = dirs[temp]*-1;												//��Ͽ� ������ ����� ������ �ݴ�� ȸ���ϱ⿡ ����
					if(list[temp].get(2)!=list[temp+1].get(6))canRotate[temp+1]=true;			//����� �������ڼ��������� ����� �����ڼ��� �ٸ��� ����������
					temp++;
					
				}
				temp = idx;
				while(temp>0) {
					dirs[temp-1] = dirs[temp]*-1;												//��Ͽ� ������ ����� ������ �ݴ�� ȸ���ϱ⿡ ����
					if(list[temp].get(6)!=list[temp-1].get(2))canRotate[temp-1]=true;			//����� �������ڼ��������� ����� �����ڼ��� �ٸ��� ����������
					temp--;
					
				}
				rotate(dir,idx);
				temp = idx;
				while(temp<3) {
					if(canRotate[temp+1]) {
						rotate(dirs[temp+1],temp+1);
					} else {
						break;
					}
					temp++;
				}
				temp = idx;
				while(temp>0) {
					if(canRotate[temp-1]) {
						rotate(dirs[temp-1],temp-1);
					} else {
						break;
					}
					temp--;
				}
//				
//				for(int k = 0; k<4; k++) {
//					for(int j = 0 ; j<list[k].size();j++) {
//						System.out.print(list[k].get(j));
//					}
//					System.out.println();
//				}
//				System.out.println(Arrays.toString(canRotate));
//				System.out.println(Arrays.toString(dirs));
//				System.out.println("==================");
				
				
				
				
			}
			
			int sum = 0;
			for(int i = 0 ; i <4;i++) {
				sum+= list[i].getFirst() * Math.pow(2, i);
			}
			System.out.format("#%d %d\n",t,sum);
			
			
			
		} // testCAse
	}
	private static void rotate(int dir,int idx) {
		if(dir==1) {
			list[idx].addFirst(list[idx].pollLast());
		} else {
			list[idx].addLast(list[idx].pollFirst());
		}
	}

}
