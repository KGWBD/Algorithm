

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Radix {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashMap<String,String> radix = new HashMap<>();
	static HashMap<String,String> password = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		radix.put("0", "0000");
		radix.put("1", "0001");
		radix.put("2", "0010");
		radix.put("3", "0011");
		radix.put("4", "0100");
		radix.put("5", "0101");
		radix.put("6", "0110");
		radix.put("7", "0111");
		radix.put("8", "1000");
		radix.put("9", "1001");
		radix.put("A", "1010");
		radix.put("B", "1011");
		radix.put("C", "1100");
		radix.put("D", "1101");
		radix.put("E", "1110");
		radix.put("F", "1111");
		
		String str = "0DEC";
		String key ="";
		String ss = "";
		for(int i = 0 ; i < str.length(); i++) {
			key = str.substring(i,i+1);
			ss += radix.get(key);
		}
		
		ss = ss.substring(0,ss.lastIndexOf("1")+1);
		ArrayList<String> list = new ArrayList<>();
		System.out.println(ss);
		while(ss.length()>5) {
			list.add(ss.substring(ss.length()-6,ss.length()));
			ss = ss.substring(ss.length()-6,ss.length());
		}
		
		for(String sss: list) {
			System.out.println(sss);
		}
		
		password.put("0","001101");
		password.put("1","010011");
		password.put("2","111011");
		password.put("3","110001");
		password.put("4","100011");
		password.put("5","110111");
		password.put("6","001011");
		password.put("7","111101");
		password.put("8","011001");
		password.put("9","101111");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
