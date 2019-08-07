package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem1983 {
	static class Student implements Comparable<Student> {
		int index;
		int score;
		String grade;

		Student(int index, int score) {
			this.index = index;
			this.score = score;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		@Override
		public int compareTo(Student s) {
			return-(new Integer(score).compareTo(s.score));
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		ArrayList<Student> list = null;
		String[] standardGrade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D" };
//
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {

			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			list.add(new Student(-1,0));
			int size = Integer.parseInt(st.nextToken());
			int searchIndex = Integer.parseInt(st.nextToken())-1;
//			System.out.println("search::"+searchIndex);
			for (int i = 0; i < size; i++) {
				int score = 0;
				st = new StringTokenizer(br.readLine());
				score += Integer.parseInt(st.nextToken()) * 35;
				score += Integer.parseInt(st.nextToken()) * 45;
				score += Integer.parseInt(st.nextToken()) * 20;
				Student student = new Student(i, score);
				list.add(student);
			}
			Collections.sort(list);
//			for(Student s:list) {
//				System.out.println(s.score);
//			}
			
			int mok = size / 10;

			for(int i = 0 ;i<size;i++) {
				if(list.get(i).index == searchIndex) {
//					System.out.println("i::" + i);
//					System.out.println("grade::"+i/mok);
					System.out.format("#%d %s\n",t,standardGrade[i/mok]);
				}
				
				
			}
			

		}

	}

}
