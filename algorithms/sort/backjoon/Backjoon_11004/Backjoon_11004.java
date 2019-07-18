import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
//      long[] a = new long[n];
      ArrayList<Long> a = new ArrayList<Long>();
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++) {
         long num = Long.parseLong(st.nextToken());
         a.add(num);
      }
      Collections.sort(a);
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      bw.write(Long.toString(a.get(k-1)));
      bw.close();
      br.close();
      
   }

}