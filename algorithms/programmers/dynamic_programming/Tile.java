class Solution {
  public long solution(int N) {
      long answer = 0;
      long[] d = new long[N+1];
      d[1] = 1;
      d[2] = 1;
      for(int i=3; i<=N; i++) {
          d[i] = d[i-1]+d[i-2];
      }
      answer = (d[N]+d[N-1])*2+d[N]*2;
      return answer;
  }
}