

public class BitTest {
	public static void main(String[] args) {
		byte a = 13, b = 7;
//		00001101   00000111
		
		
		System.out.println(1 << 3);
		
//		int c = b << 35%32;     //00001110
//		System.out.println(c);
//		
		
		
		
//		~b 는 2의보수를 취한다 -> 1의보수를 취한 후 + 1	.
//		int c = a & b; 
		
		
//		System.out.println(c);
		
		
//		String s = null;
//		if(s != null && s.length() >= 10) 다운 안된다. 
//		if(s.length() >=10 && s!=null)nullpointerException 발생
//		비트연산자는 숏서킷의 대상이 아니다. 논리는 서킷대상,   and는 앞에가 거짓이면 뒤에 진행안함,  or은 앞이 참이면 뒤에 실행안함.
		
//		short 서킷 자바에서는 짧은 단위의 논리 연산을 지원한다. &&앞의 논리가 거짓이여서 뒤에 로직은 실행하지 않고 실행된다.
//		++b 자리에는 무엇이든 올 수 있다. 
//		boolean flag = a > 20 %% ++b > 3;
		boolean flag = a > 10 && ++b > 3;
		System.out.println(flag + " , " + b);
		
		
		
	}
}
