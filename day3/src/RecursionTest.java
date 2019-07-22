public class RecursionTest {
//	static int init;
	public static void main(String[] args) {
//		1부터 10까지의 숫자를 차례로 출력하라
//		for(int i = 1; i <=10;i++) {
//			System.out.println(i);
//		}
		
//		printNum(1);
//		1부터 10까지의 합을 구하여 출력하라;
		
//		for(int i =1; i<=10;i++) {
//			sum += i;
//		}
//		System.out.println(sum);
//		int sum = doSum(10);
//		System.out.println(sum);
//		doSum1(100);
//		System.out.println("sum1 =" + sum1);
		
//		1부터 n까지의 곱의 결과를 구하여라
//		5 => 5 * 4 * 3 * 2 * 1 5!
		
//		int result = 1;
//		for(int i = 5; i>=1; i--) {
//			result *= i;
//		}
//		
//		result = factory(15);
//		System.out.println(result);
		
//		숫자의 각 자릿수의 합을 구하여 출력하라
//		int num = 12345;
//		result = 0;
//		int nam;
//		while(num > 0) {
//			nam = num % 10;
//			result += nam;
//			num /= 10;
//			
//		}
//		result = disitSum(123456,0);
//		System.out.println(result);
//		
//		result = fibo(93);
//		System.out.println(result);
//		
//		자릿수를 입력바아서 모든 가능한 이진수 문자열을 출ㄹ력하라
		doMakeBinary(3, "");
				
		
	}
	static void doMakeBinary(int size,String result) {
//		000  001 010 011 100 101 110 111
//		기저대역, 언제 빠져나가야하지? 줄여나가겠다.? n을 줄여서 어떻게 구하지?
		
//		줄여나가기 때문에 111을 찍고 재귀를 통해 110을 찍으면 되나? 마이너스를 하니깐?
		if(size == 0 ) {
			System.out.println(result);
			return;
		}
		doMakeBinary(size-1, result + "0");
		doMakeBinary(size-1, result + "1");
	}
		
		  
		
		
		
		
	
	
//	피보나치 수열;
	static int fibo(int n) {
		if(n == 1 || n == 2)return 1;
		if(n < 1) return 0;
		
		int sum = (fibo(n-1) + fibo(n-2)) ;
		
		
		return sum;
		
	}
	
	
	
	static int result = 0;
	
	static int disitSum(int n, int sum) {
		if(n<=0) {
			return sum;
		}
		int nam = n % 10;
		int mok = n / 10;
		sum += nam;
		
		return disitSum(mok, sum);
	}
	
	
	
	
	
	
	
	static int factory(int n) {
//		빼야할 부분을 알면 바로 상수로 리턴해주는 것이 좋은거다.
		if(n == 0 || n == 1) return 1;
//		if(n == 1) return 1;
		if( n < 0) {
			return -1;
		}
		
		
	
		return n * factory(n-1);
		
		
	}
	static int sum1 = 0;
	static void doSum1(int a) {
		if(a <= 0) {
			return;
		}
		sum1 += a;
		doSum1(a-1);
		
	}
	static void printNum(int num) {
//		기저대역(base Case)를 만드는 것이 재귀함수의 핵심 
//		기저대역이 없으면 자신을 계속호출하며 종료하는 시점이 없기 때문에 stack에 함수들이 계속 쌓인다 - > Stackoverflow를 발생시킨다.
//		기저대역은 상단에 위치하여 판단하게 만든다.
		
		if(num > 10) {
			return;
		}
		System.out.println(num);
		printNum(num+1);
		
		
	}
	
	static int doSum(int num) {
		if(num <= 0){
			return 0;
		}
		return num + doSum(num-1);
	}
	
	
	
}
