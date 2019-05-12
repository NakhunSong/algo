import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      sc.nextLine();
      int[][] a = new int[n+1][m+1];
      int[][] d = new int[n+1][m+1];
      
      for(int i=1; i<=n; i++) {
         for(int j=1; j<=m; j++) {
            a[i][j] = sc.nextInt();
         }
         sc.nextLine();
      }
      
      int ans = 1;
      d[1][1] = a[1][1];
      for(int j=1; j<=m; j++) {
         d[1][j] = d[1][j-1]+a[1][j];
      }
      for(int i=1; i<=1; i++) {
         d[i][1] = d[i][1] + a[i][1];
      }
      for(int i=1; i<=n; i++) {
         for(int j=1; j<=m; j++) {
            ans = d[i-1][j];
            ans = Math.max(ans, d[i][j-1]);
            d[i][j] = ans + a[i][j];
         }
      }
      System.out.println(d[n][m]);
   }

}