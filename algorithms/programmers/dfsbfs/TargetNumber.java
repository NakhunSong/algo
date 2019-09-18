class Solution {
  static int cnt = 0;
  public static void go(int[] numbers, int index, int now, int target) {
      if(index+1 == numbers.length) {
          if(now == target) cnt++;
          return;
      }
      go(numbers, index+1, now+numbers[index+1], target);
      go(numbers, index+1, now-numbers[index+1], target);
  }
  public int solution(int[] numbers, int target) {
      int answer = 0;
      go(numbers, 0, -1*numbers[0], target);
      go(numbers, 0, numbers[0], target);
      return answer=cnt;
  }
}