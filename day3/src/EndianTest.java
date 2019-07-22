
public class EndianTest {

	public static void main(String[] args) {
		int a= 654321;
		
		byte[] arr = intToByteArr(a);
		int b = byteArrToInt(arr);
		System.out.println(0xff);
		System.out.println(b);
		
	}
	
	static int byteArrToInt(byte[] brr) {
		int num = (brr[0] & 0xff) + ((brr[1] & 0xff) << 8) 
				+ ((brr[2] & 0xff) << 16) 
				+ ((brr[3] & 0xff) << 24) ;
		
		
		
		
		
		return num;
	}
	
	static byte[] intToByteArr(int num) {
		byte[] res = new byte[4];
		res[0] = (byte)num;
		res[1] = (byte)(num>>>8);
		res[2] = (byte)(num>>>16);
		res[3] = (byte)(num>>>24);
		
		return res;
		
	}
}
