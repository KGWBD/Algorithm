package day2;

public class Array2Test1 {
	
	public static void main(String[] args) {
		int[][] arr = 
			{	{0,0,0,0,0,0},
				{0,1,5,8,4,0},
				{0,3,5,2,1,0},
				{0,6,2,7,3,0},
				{0,2,6,1,3,0},
				{0,0,0,0,0,0}
			};
//		특정한 셀의 상하좌우 값의 합을 구하여 출력하라
		int sum = 0;
		//x=0 or y=0, x = 3, y = 3이면 배열첨자를 신경써야하기 때문에;
		
//		상, 하, 좌, 우
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		
		
//		4방향 탐색이기 때문에 4쓴다. 2,  4 , 8로 몇방향 탐색인지 알 수 있다;
//		for(int i = 0 ; i < 4; i++) {
//			tx = x + dx[i];
//			ty = y + dy[i];
////			시물레이션 시험에서 많이쓴다.
//			if((tx < 0|| tx >= arr.length || ty < 0 || ty >= arr.length)) {
//				continue;
//			}
//			sum+= arr[ty][tx];
//		}
		
		
//		sum = arr[y-1][x] + arr[y+1][x] + arr[y][x-1] + arr[y][x+1];
		int max = -987_654_321, mx = -1, my = -1;
		System.out.println("max" + max);
		int tx, ty;
		for(int y = 1 ; y < arr.length-1; y++) {
			for(int x = 1 ; x < arr.length-1;x++) {
				
				
					sum = 0;
				for(int i = 0 ; i < 4; i++) {
					
					
					tx = x + dx[i];
					ty = y + dy[i];
//					시물레이션 시험에서 많이쓴다.
//					if((tx < 0|| tx >= arr.length || ty < 0 || ty >= arr.length)) {
//						continue;
//					}
					
					sum+= arr[ty][tx];
					
				}
				
				if(sum > max) {
					max = sum;
					mx = x;
					my = y;
				}
				
			}
		}
		System.out.println(max);
	}
}
