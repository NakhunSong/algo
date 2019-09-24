class Solution {
  public static boolean check(int[] budgets, int mid, int M) {
      int sum = 0;
      for(int b : budgets) {
          if(b>mid) {
              sum += mid;
          } else {
              sum += b;
          }
      }
      return sum <= M;
  }
  public int solution(int[] budgets, int M) {
      long left = 1;
      long right = 0;
      long sum = 0;
      for(int b : budgets) {
          sum += b;
          right = Math.max(right, b);
      }
      if(sum <= M) {
          return (int)right;
      }
      int answer = 0;
      while(left<=right) {
          int mid = (int)(left+right)/2;
          if(check(budgets, mid, M)) {
              answer = Math.max(answer, mid);
              left = mid+1;
          } else {
              right = mid-1;
          }
      }
      return answer;
  }
}