class Solution {
  public int[] solution(int[] A, int[] B) {
      int L = A.length;
      int[] d = new int[50001];
      d[1] = 1;
      d[2] = 2;
      int maxMod = (int)Math.pow(2, 30);
      for(int i=3; i<=L; i++) {
          d[i] = (d[i-1] + d[i-2])%maxMod;
      }
      int[] answers = new int[L];
      for(int i=0; i<L; i++) {
          int num = d[A[i]];
          int mod = (int)Math.pow(2, B[i]);
          answers[i] = num%mod;
      }
      return answers;
  }
}