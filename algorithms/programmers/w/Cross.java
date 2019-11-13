class Solution {
  public int gcd(int w, int h) {
      if(h == 0) return w;
      return gcd(h, w%h);
  }
 public long solution(int w,int h) {
    long answer = 1; 
      long cross = (long)w + (long)h - (long)gcd(w, h);
      answer = (long)w * (long)h - cross;
    return answer;
 }
}