import java.util.Scanner;

public class Problem5986 {
	static int[] prime = new int[1000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		setPrime();
		prime[0] = prime[1] = 1;

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int num = sc.nextInt();
			int n;
			int cnt = 0;

			for (int x = 1; x < num; x++) {
				n = 0;

				if (prime[x] == 0) {
					for (int y = x; y < num; y++) {
						n = x;
//					System.out.println("x:: " + x );
						if (prime[y] == 0) {
							n += y;
//						System.out.println("  y:: " + y);
							if (num - n >= y && prime[num - n] == 0) {
//							System.out.println("z::"+(num-n));
								cnt++;
							}
						}

					}
				}
			}

//		System.out.println(Arrays.toString(prime));
			System.out.format("#%d %d\n",t,cnt);
		}
	}

	static void setPrime() {

		for (int i = 2; i < prime.length; i++) {
			int idx = i;

			if (prime[idx] == 0) {
				idx += i;
				while (idx < prime.length) {
					prime[idx] = 1;
					idx += i;
				}
			}

		}

	}
}
