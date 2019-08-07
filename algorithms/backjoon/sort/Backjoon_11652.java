import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      long[] cardList = new long[n];
      
      for(int i=0; i<n; i++) {
         long card = Long.parseLong(br.readLine());         
         cardList[i] = card;
      }
      Arrays.sort(cardList);
      
      long ans = cardList[0];
      int ans_cnt = 1;
      int cnt = 1;
      for(int i=0; i<n-1; i++) {
         if(cardList[i] != cardList[i+1]) {
            cnt = 1;
         } else {
            cnt += 1;
         }
         if(cnt > ans_cnt) {
            ans_cnt = cnt;
            ans = cardList[i];
         }
      }
      System.out.println(ans);
      
   }

}