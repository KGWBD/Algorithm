import java.util.concurrent.SynchronousQueue;

public class HelloWorld {
	public static void main(String[] args) {

		System.out.println("Hello 한글");
		System.out.println("Hello 한글");
		
		int a = 10;
		
		for(int i =0; i<1000; i++) {
			
		}
//		비교하는 숫자가 작을수록 연산처리가 빠르다고 한다.
		for(int i =1000; i>=0; i--) {		
		}
		
		float x = (float)20.4;
		x++;
		++x;
		//문자를 숫자로 계산하는 알고리즘  문자 '0' 에다가 -48
		char ch = 65;
		System.out.println(ch);
		ch++;
		System.out.println(ch);
		
//		byte와 byte 연산을 할 때 기본적으로 인트로 계산되는데  byte에 넣으려니 
		
//		ch = ch + 1;
		byte b1, b2, b3;
		b1 = b2 = 4;
//		b3 = b1 + b2;
		
		String results = (4>2)? "aa":"bb";
		
//		복합대입연산자의 속도가 빠름
		String s = "1";
		s += "2";
		s = s + 2;
		
		
		int num = 100;
		
		if( num > 2 ) {
			System.out.println("2보다 크다");
			
		} else {
			System.out.println("2보다 작거나 같다");
		}
		String num1 = "0";
		switch(num1) {
		case "1":
			break;
		case "2":
			
		default:
			
		}
		
		for(int i = 1; i <=10; i++) {
			System.out.println(i);
		}
		
		aaa:for(int i = 0; i < 10; i++) {
			for (int j = 0;j < 5;j++) {
				System.out.println(i + ", " + j);
				if(j==2) {
					break aaa;
				}
			}
		}
		
//		int[] arr = {1,2,3,4,5};
		
//		int[] brr[], crr, drr;
		
		int[] arr = {1,2,3,4,5,6};
		
		int sum = 0;
		for(int i:arr) {
			System.out.println(i);
		}
		
		System.out.println("sum = " + sum);
		
		int[][] frr = new int[4][];
		
		frr[0] = new int[5];
		frr[1] = new int[3];
		frr[2] = new int[7];
		frr[3] = new int[4];
		frr[2][6] = 99;
		for(int i =0; i < frr.length;i++) {
			for(int j = 0; j < frr[i].length;j++) {
				System.out.print(frr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

