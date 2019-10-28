import java.io.*;
import java.util.*;
 
public class Solution {
    public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static int n, eating = 0;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        Queue<Shark> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] == 9) {
                    q.add(new Shark(i, j, 2, 0));
                    map[i][j] = 0;
                }
            }
        }
 
        int ans = 0;
        boolean[][] visited = new boolean[n][n];
        while (!q.isEmpty()) {
            Shark shark = q.poll();
            if (!visited[shark.x][shark.y]) {
                visited[shark.x][shark.y] = true;
                if (map[shark.x][shark.y] != 0 && map[shark.x][shark.y] < shark.power) {  //�� ���̸� ã����
                    Shark curr = shark;
                    //�Ÿ� > ���� > ���� ������ �Ա� ���� ���� Queue Ž��
                    while (!q.isEmpty()) {
                        shark = q.poll();
                        if (map[shark.x][shark.y] != 0 && map[shark.x][shark.y] < shark.power) {
                            if (curr.cost == shark.cost) {
                                if (curr.x > shark.x) {
                                    curr = shark;
                                } else if (curr.x == shark.x && curr.y > shark.y) {
                                    curr = shark;
                                }
                            } else if (curr.cost > shark.cost) {
                                curr = shark;
                            }
                        }
                    }
                    map[curr.x][curr.y] = 0;
                    eating++;
                    ans += curr.cost;
                    int flag = 0;
                    if (eating == curr.power) {        //�� ������ �� ������
                        flag = 1;
                        eating = 0;
                    }
                    q.clear();
                    q.add(new Shark(curr.x, curr.y, curr.power + flag, 0));
                    visited = new boolean[n][n];
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = shark.x + dx[i];
                    int ny = shark.y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] <= shark.power && !visited[nx][ny]) {
                        q.add(new Shark(nx, ny, shark.power, shark.cost + 1));
                    }
                }
            }
        }
        System.out.println(ans);
    }
 
    public static class Shark {
        int x, y, power, cost;
 
        public Shark(int x, int y, int power, int cost) {
            this.x = x;
            this.y = y;
            this.power = power;
            this.cost = cost;
        }
    }
}
