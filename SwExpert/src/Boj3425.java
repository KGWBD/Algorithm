import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj3425 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static List<String> orderList;
	static Long standard = (long) Math.pow(10, 9);

	public static void main(String[] args) throws IOException {
		String temp;
		int N;
		Long firstNumber;
		boolean flag = false;
		orderList = new ArrayList<String>();
		while(true) {
			temp = br.readLine();
			if(temp.equals("")) {
				orderList = new ArrayList<String>();
				bw.write("\n");
				continue;
			} else if(temp.equals("QUIT"))break;
			if(!temp.equals("END")) {
				orderList.add(temp);
				continue;
			}
			N = Integer.parseInt(br.readLine());
			for(int i = 0; i<N; i++) {
				firstNumber = Long.parseLong(br.readLine());
				run(firstNumber);
			}
		}
		bw.close();

	}

	private static boolean run(Long firstNumber) throws IOException {
		Stack<Long> stack = new Stack<Long>();
		stack.push(firstNumber);
		String order;
		boolean flag = false;
		for(int i = 0 ; i < orderList.size(); i++) {
			order = orderList.get(i);
			flag = workOrder(order, stack);
			if (flag) {
				bw.write("ERROR\n");
				return true;
			}
		}
		if (stack.size() != 1)
			bw.write("ERROR" +"\n");
		else
			bw.write(stack.pop() + "\n");
		return false;
	}

	private static boolean workOrder(String order, Stack<Long> stack) {
		st = new StringTokenizer(order);
		Long temp1, temp2, result;
		int switchNumber = 1;
		switch (st.nextToken()) {
		case "NUM":
			stack.push(Long.parseLong(st.nextToken()));
			break;
		case "POP":
			if (stack.isEmpty())
				return true;
			stack.pop();
			break;
		case "INV":
			if (stack.isEmpty())
				return true;
			temp1 = stack.pop();
			result = temp1 * -1;
			stack.push(result);
			break;
		case "DUP":
			if (stack.isEmpty())
				return true;
			stack.push(stack.peek());
			break;
		case "SWP":
			if (stack.size() < 2)
				return true;
			temp1 = stack.pop();
			temp2 = stack.pop();
			stack.push(temp1);
			stack.push(temp2);
			break;
		case "ADD":
			if (stack.size() < 2)
				return true;
			temp1 = stack.pop();
			temp2 = stack.pop();
			result = temp1 + temp2;
			if (Math.abs(result)> standard) {
				return true;
			}
			stack.push(result);
			break;
		case "SUB":
			if (stack.size() < 2)
				return true;
			temp1 = stack.pop();
			temp2 = stack.pop();
			result = temp2 - temp1;
			if(Math.abs(result) > standard)return true;
			stack.push(result);
			break;
		case "MUL":
			if (stack.size() < 2)
				return true;
			temp1 = stack.pop();
			temp2 = stack.pop();
			result = temp1 * temp2;
			if (Math.abs(result)> standard)
				return true;
			
			stack.push(result);
			break;
		case "DIV":
			if (stack.size() < 2)
				return true;
			temp1 = stack.pop(); // 제수
			temp2 = stack.pop(); // 피제수
			if (temp1 == 0) {
				return true;
			}
			stack.push(temp2 / temp1);
			break;
		case "MOD":
			if (stack.size() < 2)
				return true;
			temp1 = stack.pop(); // 제수
			temp2 = stack.pop(); // 피제수
			if (temp1 == 0)
				return true;
			stack.push((temp2 % temp1));
			break;
		}
		return false;
	}
}
