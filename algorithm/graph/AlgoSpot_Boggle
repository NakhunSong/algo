import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
   
   public static class Pair{
      int x;
      int y;
      public Pair(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }
   public static String[][] a;
   public static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
   public static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
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
         Queue<Pair> q = new LinkedList<Pair>();
         for(int i=0; i<n; i++) { // 각 단어 
            String w = br.readLine().trim();
            String[] word = w.split("");
            boolean[] check = new boolean[word.length];

            String findWord = "";
            for(int x=0; x<5; x++) {
               for(int y=0; y<5; y++) {
                  if(a[x][y].equals(word[0])) {
                     q.add(new Pair(x, y));
                  }
               }
            }
            int idx = 0;
            findWord += word[0];
            check[idx] = true;
            idx += 1;
            while(!q.isEmpty()) {
               Pair p = q.remove();
               int x = p.x;
               int y = p.y;
               for(int k=0; k<8; k++) {
                  int nx = x+dx[k];
                  int ny = y+dy[k];
                  if(0<=nx&&nx<5 && 0<=ny && ny<5) {
                     if(idx<word.length && a[nx][ny].equals(word[idx]) && !check[idx]) {
                        if(findWord.length() < word.length) {
                           q.add(new Pair(nx, ny));
                           check[idx] = true;
                           findWord += a[nx][ny];
                           idx++;                           
                        }
                     }
                  }
               }
            }
            System.out.print(findWord);
            if(w.equals(findWord)) {
               System.out.println(" YES");
            } else {
               System.out.println(" NO");
            }
         }
      }
   }

}