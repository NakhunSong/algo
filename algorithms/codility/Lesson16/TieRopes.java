class Solution {
  public int solution(int K, int[] A) {
  int cnt = 0;
  int sum = 0;
  for(int i=0; i<A.length; i++) {
    if(A[i] >= K) {
      cnt++;
      sum = 0;
      continue;
    }
    sum += A[i];
    if(sum >= K) {
      cnt++;
      sum = 0;
    }
  }
  return cnt;
  }
}