class Solution {
  public int solution(int[] A) {
  int ans = 1;
  int n = A.length;
  boolean[] check = new boolean[100001];
  for(int i=0; i<n; i++) {
    if(A[i] >= 1 && A[i] <= 100000) {
      check[A[i]] = true;				
    }
  }
  for(int i=1; i<=n; i++) {
    if(check[i] == false) {
      ans = 0;
      break;
    }
  }
  return ans;
  }
}