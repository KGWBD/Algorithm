import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    private static int N;
    private static int[] dx = {0,-1,1,0,0};
    private static int[] dy = {0,0,0,-1,1};
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            ArrayList<micro> list = new ArrayList<>();
            int[][] map = new int[N][N];
            
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                
                list.add(new micro(x, y, c, v));
            }
            
            //½Ã°£
            for (int k = 0; k < M; k++) {
                //ÇÑÄ­ÀÌµ¿
                for (micro m : list) {
                    int nx = m.x + dx[m.v];
                    int ny = m.y + dy[m.v];
                    m.x = nx;
                    m.y = ny;
                    map[nx][ny]++;
                    if(!inRange(nx, ny)) {
                        if(m.v == 1) m.v = 2;
                        else if(m.v == 2) m.v = 1;
                        else if(m.v == 3) m.v = 4;
                        else if(m.v == 4) m.v = 3;
                        m.c /= 2;
                    }
                }
 
                //°ãÄ£ºÎºÐ Ã³¸®
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(map[i][j] > 1) {
                            LinkedList<micro> merge = new LinkedList<>();
                            for (micro m : list) {
                                if(m.x == i && m.y == j) merge.add(m);
                                if(merge.size() == map[i][j]) break;
                            }
                            
                            int sum = 0;
                            
                            micro temp = merge.peek();
                            for (micro m : merge) {
                                if(temp.c < m.c) temp = m;
                                sum += m.c;
                            }
                            
                            for (micro m : merge) {
                                list.remove(m);
                            }
                            temp.c = sum;
                            list.add(temp);
 
                        }
                    }
                }
                
                //¸ÊÃÊ±âÈ­
                for (micro m : list) {
                    map[m.x][m.y] = 0;
                }
            }
            
            int sum = 0;
            for (micro m : list) {
                sum += m.c;
            }
 
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    static class micro{
        int x,y,c,v;
        public micro(int x, int y, int c, int v) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.v = v;
        }
    }
    
    static boolean inRange(int x, int y) {
        return x > 0 && x < N-1 && y > 0 && y < N-1;
    }
}
 
