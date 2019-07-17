import java.io.IOException;
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

   public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);   
      int[] dx = {1, -1, 0, 0};
      int[] dy = {0, 0, 1, -1};   
      int m = sc.nextInt(); // 가로
      int n = sc.nextInt(); // 세로
      int[][] box = new int[n][m];
      int[][] dist = new int[n][m];
      Queue<Pair> q = new LinkedList<Pair>();
      for(int i=0; i<n; i++) {
         for(int j=0; j<m; j++) {
            box[i][j] = sc.nextInt();
            dist[i][j] = -1;
            if(box[i][j] == 1) {
               q.add(new Pair(i, j));
               dist[i][j] = 0;
            }
         }
      }
      while(!q.isEmpty()) {
         Pair p = q.remove();
         int x = p.x;
         int y = p.y;
         for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(0<=nx && nx<n && 0<=ny && ny<m) {
               if(box[nx][ny] == 0 && dist[nx][ny] == -1) {
                  q.add(new Pair(nx, ny));
                  dist[nx][ny] = dist[x][y] + 1;
               }
            }
         }
      }
      int ans = 0;
      for(int i=0; i<n; i++) {
         for(int j=0; j<m; j++) {
            ans = Math.max(ans, dist[i][j]);
         }
      }
      for(int i=0; i<n; i++) {
         for(int j=0; j<m; j++) {
            if(box[i][j] == 0 && dist[i][j] == -1) {
               ans = -1;
            }
         }
      }
      System.out.println(ans);
      
   }

}