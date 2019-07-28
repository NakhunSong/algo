class Solution {
  public int solution(int[] A) {
      int N = A.length;
      int small = 0;
      int max = 0;
      for(int i=0; i<N-1; i++) {
          if(i==0) {
              small = A[i];
          } else if(small > A[i]) {
              small = A[i];
          } else {
              continue;
          }
          for(int j=i+1; j<N; j++) {
              if(max < A[j] - A[i]) {
                  max = A[j] - A[i];
              }
          }
      }
      return max;
  }
}