class Solution {
    public int solution(int[] A) {
		int N = A.length;
		int max = 0;
		int hIdx = 0;
		int lIdx = 0;
		for(int i=1; i<N; i++) {
			int highest = A[hIdx];
			int lowest = A[lIdx];
			int now = A[i];
			if(now > highest) {
				max = Math.max((highest-lowest), max);
				hIdx = i;
				lIdx = i;
			} else if(now > lowest) {
				max = Math.max(now-lowest, max);
			} else if(now < lowest) {
				lIdx = i;
			}
		}
		return max;
    }
}