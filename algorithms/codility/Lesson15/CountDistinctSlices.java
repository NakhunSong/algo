class Solution {
  public int solution(int M, int[] A) {
      int N = A.length;
      boolean[] check = new boolean[M+1];
      int start = 0;
      int end = 0;
      int cnt = 0;
      while(start<N && end<N) {
          if(!check[A[end]]) {
              check[A[end]] = true;
              cnt = cnt + (end-start+1);
              end++;
          } else {
              check[A[start]] = false;
              start++;
          }
      }
      return cnt;
  }
}
// 90%