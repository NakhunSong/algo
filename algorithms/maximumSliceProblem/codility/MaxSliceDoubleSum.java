class Solution {
  public int solution(int[] A) {
  int answer = 0;
  int N = A.length;
  if(N <= 3) {
    return answer;
  }
  int[] fd = new int[N];
  fd[0] = 0;
  for(int i=1; i<N-1; i++) {
    fd[i] = fd[i-1]+ A[i];
    if(fd[i] < 0) {
      fd[i] = 0;
    }
  }
  int[] bd = new int[N];
  bd[0] = 0;
  for(int i=1; i<N-1; i++) {
    int now = A[N-1-i];
    bd[i] = bd[i-1] + now;
    if(bd[i] < 0) {
      bd[i] = 0;
    }
  }
  int max = 0;
  for(int i=1; i<N-1; i++) {
    int frontMax = fd[i-1];
    int backMax = bd[N-2-i];
    max = Math.max(max, frontMax+backMax);
  }
  return answer=max;
  }
}
