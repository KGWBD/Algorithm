

public class Test1 {
	public static void main(String[] args) {
		int num = 13;
		System.out.println(Integer.toBinaryString(num));
		String s = "1101";
		int su = Integer.parseInt(s,2);
		System.out.println(su);
		//2진법을 8진법으로 변경하라
		//2 => 10 => 8;
		
		//음의 정수를 표현하는 방법은 2의 보수를 취한다 => 1의 보수를 취한다음 1을 더한다..컴퓨터에서는 2의보수밖에없다
		num = 7;
		//~num 1의 보수..
		num = ~num +1; 
		
		
		
	}
}
