class Solution {
  public int solution(int[][] baseball) {
      int answer = 0;
      for(int i=1; i<=9; i++) {
          for(int j=1; j<=9; j++) {
              for(int k=1; k<=9; k++) {
                  int idx = 0;
                  int allCnt = 0;
                  for(int x=0; x<baseball.length; x++) {
                    int q = baseball[x][0];
                      int sCnt = 0;
                      int bCnt = 0;
                      int qi = q/100;
                      int qj = (q%100)/10;
                      int qk = (q%100)%10;
                      if(i == qi) {
                          sCnt++;
                      } else if(i == qj || i == qk) {
                        bCnt++;
                      }
                      if(j == qj) {
                        sCnt++;
                      } else if(j == qi || j == qk) {
                        bCnt++;
                      }
                      if(k == qk) {
                        sCnt++;
                      } else if(k == qi || k == qj) {
                        bCnt++;
                      }
                      if(sCnt == baseball[x][1] && bCnt == baseball[x][2]) {
                          allCnt++;
                      } else {
                          break;
                      }
                  }
                  if(allCnt == baseball.length) {
                    answer++;
                  }
              }
          }
      }
      return answer;
  }
}