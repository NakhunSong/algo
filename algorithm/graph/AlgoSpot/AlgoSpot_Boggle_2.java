import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
   public static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
   public static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
   public static String[][] a;
   public static int dfs(int x, int y, String[] word, int depth, int[] dp) {
      if(depth == word.length) {
         if(dp[depth] > 0) {
            return depth;            
         }
      }
      dp[depth] = depth;
      for(int k=0; k<8; k++) {
         int nx = x + dx[k];
         int ny = y + dy[k];
         int tmp = 0;
         if(0<=nx && nx<5 && 0<=ny && ny<5) {
            if(depth<word.length && a[nx][ny].equals(word[depth])) { // 다음꺼
               int i = depth;
               tmp = dfs(nx, ny, word, ++i, dp);
            } else {
               tmp = depth;
            }
         }
         dp[depth]= Math.max(dp[depth], tmp);
      }
      return dp[depth];
   } 
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      
      while(t-->0) {
         a = new String[5][5];
         for(int i=0; i<5; i++) {
            String[] s = br.readLine().split("");
            for(int j=0; j<5; j++) {
               a[i][j] = s[j];
            }
         }
         int n = Integer.parseInt(br.readLine()); 
         for(int i=0; i<n; i++) {
            String word = br.readLine();
            String[] wordArray = word.split(""); // 테스트 단어
            
            String findWord = "";
            findWord += wordArray[0];
            
            int ans = -1;
            int[] dp;
            for(int x=0; x<5; x++) {
               for(int y=0; y<5; y++) {
                  if(a[x][y].equals(wordArray[0])) {
                     int depth = 0;
                     dp = new int[wordArray.length+1];
                     int result = dfs(x, y, wordArray, ++depth, dp);
                     ans = Math.max(ans, result);
                  }
               }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(word+" ");
            
            if(ans == wordArray.length) {
               sb.append(" YES");
            } else {
               sb.append(" NO");
            }
            System.out.println(sb);
         }
      }
   }

}