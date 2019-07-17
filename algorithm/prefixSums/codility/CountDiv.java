class Solution {
  public int solution(int A, int B, int K) {
      int answer = 0;
      if(A == 0) {
          answer = B/K + 1;
      } else {
          answer = B/K - (A-1)/K;
      }
      return answer;
  }
}