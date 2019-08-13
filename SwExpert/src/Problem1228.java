import java.util.LinkedList;
import java.util.Scanner;

public class Problem1228 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            LinkedList<Integer> Linkedlist = new LinkedList<>();
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                Linkedlist.add(sc.nextInt());
            }
            num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                String st = sc.next();
                int where = sc.nextInt();
                int many = sc.nextInt();
                for (int k = 0; k < many; k++) {
                    Linkedlist.add(where, sc.nextInt());
                    where++;
                }

            }
            // Linkedlist.isEmpty()
            System.out.print("#" + t + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(Linkedlist.poll() + " ");
            }
            System.out.println();

        }
    }
}