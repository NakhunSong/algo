import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
   int x;
   int y;
   Pair(int x, int y) {
      this.x = x;
      this.y = y;
   }   
}
public class Main {
   static int n;
   static int[] dx = {0, 0, 1, -1};
   static int[] dy = {1, -1, 0, 0};
   static int[][] a;
   static int[][] check;
   static int[] ans;
   
   public static void bfs(int x, int y, int cnt) {
      Queue<Pair> q = new LinkedList<Pair>();
      q.add(new Pair(x, y));
      check[x][y] = cnt;
      while(!q.isEmpty()) {
         Pair p = q.remove();
         x = p.x; 
         y = p.y;
         for(int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(0 <= nx && nx < n && 0 <= ny && ny < n) {
               if(a[nx][ny] == 1 && check[nx][ny] == 0) {
                  q.add(new Pair(nx, ny)); 
                  check[nx][ny] = cnt;                  
               }
            }
         }
      }
   }
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      sc.nextLine();
      
      a = new int[n][n];
      for(int i=0; i<n; i++) {
         String s = sc.nextLine();
         for(int j=0; j<n; j++) {
            a[i][j] = s.charAt(j)-'0';
         }
      }
      
      check = new int[n][n];
      int cnt = 0;
      for(int i=0; i<n; i++) {
         for(int j=0; j<n; j++) {
            if(a[i][j] == 1 && check[i][j] == 0) {
               bfs(i, j, ++cnt);
            }
         }
      }
      System.out.println(cnt);
      
      ans = new int[cnt+1];
      for(int i=0; i<n; i++) {
         for(int j=0; j<n; j++) {
            if(check[i][j] != 0) {
               ans[check[i][j]] += 1;               
            }
         }
      }
      Arrays.sort(ans);
      for(int i=1; i<=cnt; i++) {   
         System.out.println(ans[i]);
      }
   }
}