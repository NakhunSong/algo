class Solution {
  public int solution(int n) {
      int answer = 0;
      int mod = 1000000007;
      int[] d = new int[n+1];
      d[1] = 1;
      d[2] = 2;
      for(int i=3; i<=n; i++) {
          d[i] = (d[i-1] + d[i-2])%mod;
      }
      answer = d[n];
      return answer;
  }
}