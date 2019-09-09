class Solution {
  int n;
  int[][] Board;
  public boolean check(int row, int col) {
      for(int i=0; i<row; i++) {
          if(Board[i][col] != 0) return false;
      }
      return true;
  }
  public boolean find(int row, int col, int h, int w) {
      int zero = 0;
      int last = -1;
      for(int i=row; i<row+h; i++) {
          for(int j=col; j<col+w; j++) {
              if(Board[i][j] == 0) {
                  if(!check(i, j)) return false;
                  zero++;
                  if(zero > 2) return false;
              } else {
                  if(last != -1 && Board[i][j] != last) return false;
                  last = Board[i][j];
              }
          }
      }
      for(int i=row; i<row+h; i++) {
          for(int j=col; j<col+w; j++) {
              Board[i][j] = 0;
          }
      }
      return true;
  }
  public int solution(int[][] board) {
      n = board.length;
      Board = board;
      int answer = 0;
      int cnt;
      do {
          cnt = 0;
          for(int i=0; i<n; i++) {
              for(int j=0; j<n; j++) {
                  if(i<=n-2 && j<=n-3 && find(i, j, 2, 3)) {
                      cnt++;
                  }
                  if(i<=n-3 && j<=n-2 && find(i, j, 3, 2)) {
                      cnt++;
                  }
              }
          }
          answer += cnt;
      } while(cnt != 0);
      
      return answer;
  }
}