import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		//    100 x 100 배열 생성
		int[][] arr = new int[100][100];
		int testCase = 10;						//testCase = 0 설정
		for (int k = 0; k < testCase; k++) {
			
			int testNum = sc.nextInt();			//testNum 입력
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();	// 배열 초기화
				}
			}
			
			// 우, 상, 좌 방향 탐색하기 위해서;
			int[] dx = { 1, 0, -1 };
			int[] dy = { 0, -1, 0 };

			int x = 0;
			int y = 99;
			for (int i = 0; i < arr.length; i++) {
				if (arr[99][i] == 2)
					x = i;
			}

			while (y != 0) {
				if (((x + dx[0] >= 0) && (x + dx[0] < 100)) && arr[y][x + dx[0]] == 1) {
					arr[y][x] = 2;
					x += dx[0];
				} else if (((x + dx[2] >= 0) && (x + dx[2] < 100)) && arr[y][x + dx[2]] == 1) {
					arr[y][x] = 2;
					x += dx[2];
				} else {
					y += dy[1];
				}
			}

			System.out.println(String.format("#%d %d",testNum,x));

		}

	}
}
