import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int e = sc.nextInt();
      int s = sc.nextInt();
      int m = sc.nextInt();
      int E = 1;
      int S = 1;
      int M = 1;
      int cnt = 1;
      while(true){
         if(E == e && S == s && M == m) {
            break;
         }
         E++;
         S++;
         M++;
         if(E>15) {
            E = 1;
         }
         if(S>28) {
            S = 1;
         }
         if(M > 19) {
            M = 1;
         }
         cnt += 1;
      }
      System.out.println(cnt);
   }

}