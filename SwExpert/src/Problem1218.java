
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1218 {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
//			Stack<Character> left = new Stack<Character>();
			List<Character> left = new ArrayList<Character>();
			int len = 182;
			for (int t = 1; t <= 10; t++) {
				left.clear();
				len = Integer.parseInt(sc.nextLine());
				char[] chars = sc.nextLine().toCharArray();
				boolean flag = false;
				int result = 1;
				char ch = '\u0000';
				int size = 0;
				for (int i = 0; i < len; i++) {
					ch = chars[i];
					
					if (ch == '(' || ch == '<' || ch == '{' || ch == '[') {
						left.add(ch);
					} else {
						size = left.size()-1;
						ch = left.get(size);
						left.remove(size);
						if (ch == '(') {
							flag = (chars[i] - ch) == 1 ? false : true;
						} else {
							flag = (chars[i] - ch) == 2 ? false : true;
						}
					}
					if (flag) {
						result = 0;
						break;
					}
				}
				System.out.println(String.format("#%d %d", t,result));
			}

		}
}