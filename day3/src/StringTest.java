import java.util.Arrays;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class StringTest {

	public static void main(String[] args) {
		String s = "korea";
		String s1 = "korea";
		
//		if(s.equals(s1) ) 
		if("korea".equals(s) )  //s.equals("korea")     ,   null오류 방지 
		{
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		s = "한글korea";  		// 자바의 불변성
		System.out.println(s.length());
		s = s.toUpperCase();
		System.out.println(s);
		s = "korea japan korea japan java";
//		s = s.replace("japan", "o");
		s = s.replaceAll("korea", "한글");
		String[] srr = s.split(" ");
		System.out.println(Arrays.toString(srr));
		s = "koreaJapan";
		s = s.substring(3,5);
		System.out.println(s);
		
//		char ch = s.charAt(3);
//		char[] charr = s.toCharArray();
//		s = String.valueOf(120);
		String name = "홍길동";
		int age = 30;
		System.out.println(String.format("이름은 %s 나이는 %d 입니다.",name,age));
		
		String s2 = "korea";
		String s3 = s2;
		
		String ss = "algorithm";
		char[] schar = ss.toCharArray();
		int len = schar.length/2;
		int max = schar.length - 1;
		char temp;
		for(int i = 0; i < len; i++) {
			
			temp = schar[i];
			schar[i] = schar[max-i];
			schar[max-i] = temp;
			
		}
		String sss = new String(schar);
		System.out.println(sss);
		String ssss = "algorithm";
		StringBuilder sb = new StringBuilder(ssss);
		String ssssss = sb.reverse().toString();
		
		String jum = "100";
		int num1 = Integer.parseInt(jum);
		System.out.println(num1 / 10);
		num1 = 1234;
//		num1 값을 이진수로 변환하라
		System.out.println(Integer.toBinaryString(num1));
		
		
		
		
	}
}
