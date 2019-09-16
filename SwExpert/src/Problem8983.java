import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 

 
public class Problem8983{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); 
        int N = Integer.parseInt(st.nextToken()); 
        long L = Integer.parseInt(st.nextToken()); 
        int ans = 0;
        long yy = Long.MIN_VALUE;
        long xx = Long.MIN_VALUE;
        long[] gun = new long[M+1];
        pair[] animal = new pair[N];
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int token = Integer.parseInt(st.nextToken());
 
            gun[i] = token;
        }
        gun[M] = 1000000001;
        Arrays.sort(gun);
 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
             
 
            animal[i] = new pair(x, y);
        }
        Arrays.sort(animal);
 
       
        int cur = 0;
        for (int i = 0; i < N; i++) {
            pair p = animal[i];
            int ax = p.x;
            int ay = p.y;
            if (ay > L || ax < gun[0] - L ) continue;
            
          
            if (ax > gun[M - 1] + L) break;
 
            for (int j = cur; j < M; j++) { // 사대 검사
                long dist = getDist(gun[j],ax,ay);
                if(dist<=L) {
                    ans++;
                    cur = j;
                    break;
                }
              
                if(ax<gun[j]) break;
 
            }
 
        }
 
        System.out.println(ans);
    }
 
    public static long getDist(long x, int a, int b) {
        return Math.abs(x - a) + b;
    }
 
    static class pair implements Comparable<pair> {
        int x;
        int y;
 
        public pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
 
        @Override
        public int compareTo(pair o) {
            // TODO Auto-generated method stub
            return this.x-o.x;//오름차순 
        }
    }
}
 
