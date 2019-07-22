import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Problem2063 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberCnt = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] arr = new int[numberCnt];
        int index = 0;
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        int min = 0;
        int tmp = 0;
        int middleIndex = arr.length / 2;
     
        for(int i = 0; i < arr.length-1; i ++) {
            min = i;
            for(int j = i+1; j<arr.length;j++) {
                if(arr[j] < arr[min] ) {
                    min = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        System.out.println(arr[middleIndex]);
    }
}