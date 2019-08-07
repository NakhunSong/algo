class Solution {
  public int[] solution(int[] A, int K) {
  int[] temp = new int[A.length];
  
  while(K-- > 0) {
    for(int i=0; i<A.length; i++) {
      if(i+1 > A.length-1) {
        temp[0] = A[i];
      } else {
        temp[i+1] = A[i];					
      }
    }
    A = temp.clone();			
  }
  return A;
  }
}