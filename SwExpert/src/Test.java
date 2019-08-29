public class Test {
	public static void main(String[] args) {
		
		for(int i = 1; i < 100000000; i++) {
			if(Math.pow(i, 2)>Math.pow(10, 12)) {
				System.out.println(i);
				break;
			}
		}
		
		
		
	}
}
