import java.util.Scanner;

public class Main {
   static long ans = 0;
   static long mod = 1000000007;
   static int n;
   static int[] d = new int[51];
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      d[0] = 1;
      d[1] = 1;
      d[2] = 3;
      for(int i=3; i<=n; i++) {
         d[i] = d[i-1] + d[i-2] + 1;
         d[i] %= mod;
      }
      System.out.println(d[n]);
   }

}