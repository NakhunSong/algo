class Solution {
  static int min = 100;
  static boolean check(String word, String next) {
      int cnt = 0;
      for(int i=0; i<word.length(); i++) {
          if(word.charAt(i) != next.charAt(i)) {
              cnt++;
          }
      }
      if(cnt != 1) return false;
      return true;
  }
  static void go(String word, String target, String[] words, boolean[] c, int cnt) {
      if(word.equals(target)) {
          min = Math.min(min, cnt);
          return;
      }
      for(int i=0; i<words.length; i++) {
          if(c[i] == false && check(word, words[i])) {
              c[i] = true;
              go(words[i], target, words, c, cnt+1); // 이 부분 cnt++라고 하면 값이 이상하게 산정된다. cnt++ 와 cnt+1 의 차이 
              c[i] = false;
          }
      }
  }
  public int solution(String begin, String target, String[] words) {
      int answer = 0;
      boolean[] c = new boolean[words.length];
      go(begin, target, words, c, 0);
      if(min == 100) min = 0;
      return min;
  }
}