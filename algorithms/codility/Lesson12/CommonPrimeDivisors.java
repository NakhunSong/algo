class Solution {
	public int getGcd(int a, int b) {
		if(a % b == 0) return b;
		return getGcd(b, a%b);
	}
  public int solution(int[] A, int[] B) {
		int Z = A.length;
    int cnt = 0;
		for(int i=0; i<Z; i++) {
      int a = A[i];
      int b = B[i];
      boolean okA = false;
      boolean okB = false;
      int gcd = getGcd(a, b);
      while(a!=1) {
        int g = getGcd(a, gcd);
        if(g == 1) {
          break;
        }
        a = a/g;
      }
      if(a == 1) okA = true;
      while(b!=1) {
        int g = getGcd(b, gcd);
        if(g == 1) {
          break;
        }
        b = b/g;
      }
      if(b == 1) okB = true;
      if(okA && okB) {
				cnt++;
			}
		}
		return cnt;
  }
}