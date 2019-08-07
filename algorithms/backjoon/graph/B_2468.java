import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
   public static class Pair {
      int x;
      int y;
      Pair(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }
   public static final int[] dx = {0, 0, 1, -1};
   public static final int[] dy = {1, -1, 0, 0};
   public static int n;
   public static int[][] a;
   
   public static int bfs(int[][] group, int x, int y, int rain, int cnt) {
      Queue<Pair> q = new LinkedList<Pair>();
      q.add(new Pair(x, y));
      group[x][y] = cnt;
      while(!q.isEmpty()) {
         Pair p = q.remove();
         x = p.x;
         y = p.y;
         for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(0<=nx && nx<n && 0<=ny && ny < n) {
               if(a[nx][ny] > rain && group[nx][ny] == 0) {
                  group[nx][ny] = cnt;
                  q.add(new Pair(nx, ny));
               }
            }
         }
      }
      return cnt;
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      n = Integer.parseInt(br.readLine());
      a = new int[n][n];
      int max_h = 0;
      for(int i=0; i<n; i++) {
         st = new StringTokenizer(br.readLine());
         for(int j=0; j<n; j++) {
            a[i][j] = Integer.parseInt(st.nextToken());
            max_h = Math.max(a[i][j], max_h);
         }
      }
      int ans = 0;
      for(int k=0; k<=max_h; k++) {
         int cnt = 0;
         int max_g = 0;
         int[][] group = new int[n][n];
         for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
               if(a[i][j] > k && group[i][j] == 0) {
                  max_g = bfs(group, i, j, k, ++cnt);
               }
            }
         }
         for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
               System.out.print(group[i][j] + " ");
            }
            System.out.println();
         }
         System.out.println("rain: " + k + ", " + max_g);
         ans = Math.max(max_g, ans);
      }
      System.out.println(ans);
   }

}