import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
   static class Pair {
      int x;
      int y;
      Pair(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }
   static int n;
   static int[] dx = {1, -1, 0, 0};
   static int[] dy = {0, 0, 1, -1};
   static int[][] a;
   static int[][] land;
   public static void island(int x, int y, int cnt) {
      Queue<Pair> q = new LinkedList<Pair>();
      q.add(new Pair(x, y));
      land[x][y] = cnt;
      while(!q.isEmpty()) {
         Pair p = q.remove();
         x = p.x;
         y = p.y;
         for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(0<=nx && nx<n && 0<=ny && ny<n) {
               if(a[nx][ny] == 1 && land[nx][ny] == 0) {
                  land[nx][ny] = cnt;
                  q.add(new Pair(nx, ny));
               }
            }
         }
      }
   }
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      a = new int[n][n];
      for(int i=0; i<n; i++) {
         for(int j=0; j<n; j++) {
            a[i][j] = sc.nextInt();
         }
      }
      land = new int[n][n];
      int cnt = 0;
      for(int i=0; i<n; i++) {
         for(int j=0; j<n; j++) {
            if(a[i][j] == 1 && land[i][j] == 0) {
               island(i, j, ++cnt);
            }
         }
      }
      for(int i=0; i<n; i++) {
         for(int j=0; j<n; j++) {
            System.out.print(land[i][j]);
         }
         System.out.println();
      }
   }

}