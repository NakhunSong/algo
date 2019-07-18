class Solution {
  public int solution(int X, int Y, int D) {
  int answer = Y-X;
  if((Y-X)%D == 0) {
    answer = answer/D;
  } else {
    answer = answer/D + 1;			
  }
  return answer;
  }
}