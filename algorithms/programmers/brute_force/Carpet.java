class Solution {
  public int[] solution(int brown, int red) {
      int[] answer = {0, 0};
      int sqrt = (int)Math.sqrt(red);
      for(int i=sqrt; i>=1; i--) {
          if(red%i == 0) {
              int insideW = red/i;
              int insideH = i;
              int totalW = insideW+2;
              int totalH = insideH+2;
              if(totalW*totalH == brown+red) {
                  answer[0] = totalW;
                  answer[1] = totalH;
                  break;
              }
          }
      }
      return answer;
  }
}