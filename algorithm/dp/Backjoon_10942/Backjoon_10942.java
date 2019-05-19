import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      String[] str = br.readLine().split(" ");
      int[] a = new int[n+1];
      int[][] d = new int[n+1][n+1];
      for(int i=1; i<=n; i++) {
         a[i] = Integer.parseInt(str[i-1]);
      }
      int m = Integer.parseInt(br.readLine());
      
      for(int i=1; i<=n; i++) { // 길이가 1
         d[i][i] = 1;
      }
      for(int i=1; i<n; i++) { // 길이가 2
         if(a[i] == a[i+1]) {
            d[i][i+1] = 1;
         }
      }
      for(int i=3; i<=n; i++) {
         for(int j=1; j<=n-i+1; j++) {
            int k = j+i-1;
            if(a[j] == a[k] && d[j+1][k-1] == 1) {
               d[j][k] = 1;
            }
         }
      }
      StringBuilder sb = new StringBuilder();
      while(m-->0) {
         String[] line = br.readLine().split(" ");
         int s = Integer.parseInt(line[0]);
         int e = Integer.parseInt(line[1]);
         
         sb.append(d[s][e] + "\n");
      }
      
      
      bw.write(sb.toString());
      bw.close();
      br.close();
   }
}