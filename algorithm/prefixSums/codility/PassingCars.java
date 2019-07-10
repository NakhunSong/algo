class Solution {
  public int solution(int[] A) {
      int ans = 0;
      int zeroCnt = 0;
      for(int i=0; i<A.length; i++) {
          if(A[i] == 0) {
              zeroCnt += 1;
          } else if(A[i] == 1) {
              ans += zeroCnt;
          }
          if(ans > 1000000000) {
              ans = -1;
              break;
          }
      }
      return ans;
  }
}