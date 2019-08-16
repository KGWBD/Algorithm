public class Solution123 {

	public static void main(String[] args) {
		String s = "Rhs0266";
		char[] chars = s.toCharArray();
		for(int k=0;k<chars.length;k++) {
			if(k==0) {
				if(chars[k]-'A'<0 || chars[k]-'A'>25) {
					System.out.println("1 "+k);
					continue;
				}
			} else {
				if(chars[k]-'A'>=0 && chars[k]-'A'<=25) {
					System.out.println("2 "+k);
					continue;
				} else if(chars[k]-'0' >= 0 && chars[k] -'0' <9) {
					contin
				}
			}
		}
	}

}
