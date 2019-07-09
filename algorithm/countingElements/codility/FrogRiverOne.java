class Solution {
  public int solution(int X, int[] A) {
  int ans = 0;
  int N = A.length;
  int[] check = new int[100001];
  for(int i=0; i<N; i++) {
    if(A[i] >= 1 && A[i] <=100000) {
      if(check[A[i]] == 0) {
        if(i == 0) {
          check[A[i]] = -1;						
        } else {
          check[A[i]] = i;
        }
      } else {
        continue;					
      } 
    }
  }
  for(int i=1; i<=X; i++) {
    if(check[i] == 0) {
      ans = -1;
      break;
    } else {
      ans = Math.max(ans, check[i]);				
    }
  }
  return ans;
  }
}