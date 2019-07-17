class Solution {
  public int[] solution(String S, int[] P, int[] Q) {
  int N = S.length();
  int[] A = new int[N+1];
  int[] C = new int[N+1];
  int[] G = new int[N+1];
  int[] answer = new int[P.length];
  for(int i=0; i<N; i++) {
    char c = S.charAt(i);
    if(c == 'A') {
      A[i+1]++;
    } else if(c == 'C') {
      C[i+1]++;
    } else if(c == 'G') {
      G[i+1]++;
    }
    A[i+1] += A[i];
    C[i+1] += C[i];
    G[i+1] += G[i];
  }
  
  for(int i=0; i<P.length; i++) {
    if(A[Q[i]+1] > A[P[i]]) {
      answer[i] = 1;
    } else if(C[Q[i]+1] > C[P[i]]) {
      answer[i] = 2;
    } else if(G[Q[i]+1] > G[P[i]]) {
      answer[i] = 3;
    } else {
      answer[i] = 4;
    }
  }
  return answer;
  }
}