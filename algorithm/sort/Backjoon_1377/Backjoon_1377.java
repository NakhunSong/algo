import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
   static class Pair implements Comparable<Pair> {
      int input;
      int idx;
      
      public Pair(int input, int idx) {
         this.input = input;
         this.idx = idx;
      }
      
      @Override
      public int compareTo(Pair p) {
         if(input > p.input) {
            return 1;
         } else if(input == p.input) {
        	 return 0;
         } else {
        	 return -1;        	 
         }
      }
      
   }
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      List<Pair> a = new ArrayList<Pair>();
      
      for(int i=1; i<=n; i++) {
         st = new StringTokenizer(br.readLine());
         int num = Integer.parseInt(st.nextToken());
         a.add(new Pair(num, i));
      }
      Collections.sort(a);
      
      int max = 0;
      int cnt = 1;
      
      for(Pair data : a) {
         if(data.idx > cnt) {
            if(data.idx - cnt > max) {
               max = data.idx-cnt;
            }
         }
         cnt++;
      }
      
      System.out.println(max+1);
   }

}