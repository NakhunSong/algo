class Solution {
  public int solution(int[] A) {
  int answer = 0;
  boolean[] check = new boolean[100002];
  for(int i=0; i<A.length; i++) {
    check[A[i]] = true;
  }
  for(int i=1; i<=check.length; i++) {
    if(check[i] == false) {
      answer = i;
      break;
    }
  }
  return answer;
  }
}