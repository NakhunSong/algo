class Solution {
    public int solution(int N, int M) {
		int a = N;
		int b = M;
		int gcd = 0;
		while(b!=0) {
			int r = a % b;
			if(r == 0) {
				gcd = b;
				break;
			}
			a = b;
			b = r;
		}
		return N/gcd;
    }
}