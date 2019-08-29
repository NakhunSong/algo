class Solution {
  public int[] D;
public int getMax(int index) {
  D[index] = D[index-1];
  for(int i=2; i<=6; i++) {
    if(index-i>=0) {
      D[index] = Math.max(D[index], D[index-i]);				
    }
  }
  return D[index];
}
  public int solution(int[] A) {
  int N = A.length;
  D = new int[N];
  D[0] = A[0];
  for(int i=1; i<N; i++) {
    D[i] = getMax(i);
    D[i] += A[i];
  }
  int ans = D[N-1];
  return ans;
  }
}