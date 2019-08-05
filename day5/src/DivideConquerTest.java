
public class DivideConquerTest {

	public static void main(String[] args) {
		int num = 2;
		int pow = 60;
		long start = System.currentTimeMillis();
//		long result = doPow(num, pow);
//		long result = doPow1(num, pow);
		long result = doPow2(num, pow);
		System.out.println(result);
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
	}
	static long doPow2(int base, int exp) {
		if(exp==0)return 1;
		else if(exp==1)return base;

		long num = doPow2(base,exp/2);
		long result = num*num;
		if(exp%2==1) {
			result *= base;
		}
		return result;
		
	}
	
	static long doPow1(int base, int exp) {
		if(exp==0) {
			return 1;
		}
		return base * doPow1(base,exp-1);
		
	}
	private static int doPow(int base, int exp) {
		long result = 1;
		for(int i = 0; i < exp; i++) {
			result *= base;
		}
		
		
		
		return 0;
	}
}
