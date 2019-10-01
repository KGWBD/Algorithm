package day18;

public class FiboTest {
	static long[] dp;
	public static void main(String[] args) {
		int num = 50;
		dp = new long[num];
		dp[1] = dp[2] = 1;
//		long res = fibo(45);
//		System.out.println(res);
		long start = System.currentTimeMillis();
//		System.out.println(fibo(45));
		fibo(45);
		System.out.println(dp[45]);
		System.out.println(System.currentTimeMillis()-start);
	}
	

	private static long fibo(int n) {
		if(n <= 2 ) return dp[n];
		if(dp[n]!=0)return dp[n];
		dp[n] = fibo(n-1) + fibo(n-2);
		return dp[n];
	}
}
