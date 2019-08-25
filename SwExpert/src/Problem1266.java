import java.io.IOException;
import java.util.Scanner;
 
public class Problem1266{
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
 
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            double n1 = sc.nextDouble() / 100.0;
            double n2 = sc.nextDouble() / 100.0;
            double sum1, sum2;
            sum1 = sum2 = 0;
 
            sum1 += Math.pow(n1, 2) * Math.pow(1 - n1, 16) * combi(2);
            sum1 += Math.pow(n1, 3) * Math.pow(1 - n1, 15) * combi(3);
            sum1 += Math.pow(n1, 5) * Math.pow(1 - n1, 13) * combi(5);
            sum1 += Math.pow(n1, 7) * Math.pow(1 - n1, 11) * combi(7);
            sum1 += Math.pow(n1, 11) * Math.pow(1 - n1, 7) * combi(11);
            sum1 += Math.pow(n1, 13) * Math.pow(1 - n1, 5) * combi(13);
            sum1 += Math.pow(n1, 17) * Math.pow(1 - n1, 1) * combi(17);
 
            sum2 += Math.pow(n2, 2) * Math.pow(1 - n2, 16) * combi(2);
            sum2 += Math.pow(n2, 3) * Math.pow(1 - n2, 15) * combi(3);
            sum2 += Math.pow(n2, 5) * Math.pow(1 - n2, 13) * combi(5);
            sum2 += Math.pow(n2, 7) * Math.pow(1 - n2, 11) * combi(7);
            sum2 += Math.pow(n2, 11) * Math.pow(1 - n2, 7) * combi(11);
            sum2 += Math.pow(n2, 13) * Math.pow(1 - n2, 5) * combi(13);
            sum2 += Math.pow(n2, 17) * Math.pow(1 - n2, 1) * combi(17);
 
            System.out.format("#%d %.6f\n", t, (1 - (1 - sum1) * (1 - sum2)));
        }
    }
 
    private static double combi(int exponent) {
        double ans = 1.0;
        for (int i = 1; i <= exponent; i++) {
            ans *= 19 - i;
            ans /= i;
        }
 
        return ans;
    }
}