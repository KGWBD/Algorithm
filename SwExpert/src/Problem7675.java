import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem7675 {
	static ArrayList<String> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int tc = Integer.parseInt(br.readLine());
		String str = "";
		String[] arr = null;
		char[] chars = null;
		int cnt = 0;
		for (int t = 1; t <= tc; t++) {
			
			int N = Integer.parseInt(br.readLine());
			str = br.readLine();
			list = new ArrayList<String>();
			separtor(str);
			System.out.print("#"+t);
			for (int i = 0; i < N; i++) {
										//!,?,. �������� �����Ͽ� �ܾ� ����
				arr = list.get(i).split(" ");		//���� �ܾ �迭�� �ٽ� ���� ����
				cnt = 0;
				th:for(int j =0; j< arr.length;j++) {	//�Ѵܾ �˻�;
					chars = arr[j].toCharArray();	//�ѱ��ھ� ���ϱ����� ¥��	
					for(int k=0;k<chars.length;k++) {
						if(k==0) {
							if(chars[k]-'A'<0 || chars[k]-'A'>25) {
								continue th;
							}
						} else {
							if(chars[k]-'a'<0 || chars[k]-'a' >25) {
								continue th;
							}
							
						}
					}
					cnt++;
				}//th �Ѵܾ� �˻� ��
				
				System.out.print(" "+cnt);
			}
			System.out.println();
		}

	}

	static void separtor(String str) {
		int idx=0;
		int start=0;
		char c = '\u0000';
		while(idx<str.length()) {
			c = str.charAt(idx);
			if(c=='!' || c=='?' || c=='.' ) {
				
				list.add(str.substring(start,idx).trim());
				start = idx+1;
			}
			idx++;
			
		}
		
		
	}
}
