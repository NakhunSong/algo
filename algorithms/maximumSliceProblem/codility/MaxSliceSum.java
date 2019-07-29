class Solution {
  public int solution(int[] A) {
      int N = A.length;
      int[] dp = new int[N];
      dp[0] = A[0];
      for(int i=1; i<N; i++) {
          dp[i] = dp[i-1]+A[i];
          if(dp[i] < A[i]) {
              dp[i] = A[i];
          }
      }
      int answer = dp[0];
      for(int i=1; i<N; i++) {
          answer = Math.max(answer, dp[i]);
      }
      return answer;
  }
}