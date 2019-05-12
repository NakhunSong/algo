import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      
      for(int i=0; i<t; i++) {
         int n = sc.nextInt();
         int[] d = new int[n+1];
         d[1] = 1;
         d[2] = 1;
         d[3] = 1;
         for(int j=4; j<=n; j++) {
            d[j] = d[j-2] + d[j-3];
         }
         System.out.println(d[n]);
      }
   }

}