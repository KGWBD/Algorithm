import java.util.Scanner;

public class Boj7568 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb;
	public static void main(String[] args) {
		
		int N = sc.nextInt();
		Person[] people = new Person[N];
		for(int i = 0 ; i < N; i++) {
			int weight = sc.nextInt();
			int height = sc.nextInt();
			people[i] = new Person(weight,height);
			sb = new StringBuilder();
		}
		for(int i = 0 ; i < N; i++) {
			Person p = people[i];
			int cnt = 1;
			for(int j = 0 ; j < N; j++) {
				if(i==j)continue;
				Person tmp = people[j];
				if(p.height < tmp.height && p.weight < tmp.weight) {
					cnt++;
				}
			}
			sb.append(cnt + " ");
		}
		System.out.println(sb.toString().trim());
	}
	
	
	static class Person{
		int weight;
		int height;
		Person(int weight, int height){
			this.weight = weight;
			this.height = height;
		}
	}
}
