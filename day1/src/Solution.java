	import java.util.Scanner;
	
	public class Solution {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int testCase = sc.nextInt();
			for (int p = 0; p < testCase; p++) {
	
				int index = 0;
	
				String[] input = sc.nextLine().split("");
				boolean[] b_input = new boolean[input.length];
				for (int i = 0; i < input.length; i++) {
					if (Integer.parseInt(input[i]) == 1) {
						b_input[i] = true;
					} else {
						b_input[i] = false;
					}
				}
				boolean[] results = new boolean[input.length];
				for (int k = 0; k < b_input.length; k++) {
					results[k] = false;
				}
	
				index = b_input.length - 1;
				int count = 0;
				int f_result = 0;
				int t_result = 0;
				aaa: while (true) {
	
					if (index == 0) {
						index = b_input.length - 1;
					}
	
					if (b_input[index] == b_input[index - 1]) {
						index = index - 1;
					} else if (b_input[index] != b_input[index - 1]) {
						for (int i = index; i < b_input.length; i++) {
							b_input[i] = !b_input[i];
						}
	//				System.out.println("바꾸기");
						count += 1;
						index = b_input.length - 1;
					}
					f_result = 0;
					t_result = 0;
					for (int i = 0; i < b_input.length; i++) {
						if (b_input[i] == false) {
							f_result += 1;
						} else if (b_input[i] == true) {
							t_result += 1;
						}
						if (f_result == b_input.length) {
	//					System.out.println("f_result :" + f_result);
	//					System.out.println("끝남");
							break aaa;
						} else if (t_result == b_input.length) {
	//					System.out.println("+1한 다음에 결과" + t_result);
							count += 1;
							break aaa;
						}
					}
				}
	
				System.out.println(count);
			}
		}
	}