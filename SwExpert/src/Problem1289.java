import java.util.Scanner;

public class Problem1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		sc.nextLine();
		for (int t = 0; t < testCase; t++) {

			String input = sc.nextLine();

			String[] inputs = input.split("");
			boolean flag = false;
			int inputsLen = inputs.length;
			int cnt = 0;
			boolean[] bInputs = new boolean[inputsLen];
			
			for (int i = 0; i < inputsLen; i++) {
				if (inputs[i].equals("1"))
					bInputs[i] = true;
				else
					bInputs[i] = false;
			}

			for (int i = 0; i < inputsLen; i++) {
				if (bInputs[i] == true)
					flag = true;
				else
					flag = false;

				if (flag) {
					for (int j = i; j < inputsLen; j++) {
						bInputs[j] = !bInputs[j];
					}
					cnt++;

				}

			}

			System.out.printf("#%d %d\n", t + 1, cnt);

		}

	}
}
