class Solution {
  public int solution(int[] A, int[] B) {
  int N = A.length;
  if(N == 0) {
    return 0;
  }
  int cnt = 1;
  int last = B[0];
  for(int i=1; i<N; i++) {
    if(last < A[i]) {
      cnt++;
      last = B[i];
    }
  }
  return cnt;
  }
}