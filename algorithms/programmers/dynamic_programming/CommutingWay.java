class Solution {
  static int[] dx = {0, 1};
  static int[] dy = {1, 0};
  static int[][] a;
  static int ans = 0;
  static int mod = 1000000007;
  public static void go(int x, int y, boolean[][] check) {
      if(x == check.length-1 && y == check[0].length-1) ans += 1;
      for(int k=0; k<2; k++) {
          int nx = x + dx[k];
          int ny = y + dy[k];
          if(nx>=1 && nx<check.length && ny>=1 && ny<check[0].length) {
              if(a[nx][ny] != 1 && !check[nx][ny]) {
                  check[nx][ny] = true;
                  go(nx, ny, check);
                  check[nx][ny] = false;
              }
          }
      }
  }
  public int solution(int m, int n, int[][] puddles) {
      boolean[][] check = new boolean[n+1][m+1];
      a = new int[n+1][m+1];
      for(int i=0; i<puddles.length; i++) {
          int col = puddles[i][0];
          int row = puddles[i][1];
          a[row][col] = 1;
      }
      check[1][1] = true;
      go(1, 1, check);
      return ans%mod;
  }
}