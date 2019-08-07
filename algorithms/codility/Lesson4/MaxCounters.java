class Solution {
    public int solution(int X, int[] A) {
		int[] ans = new int[N];
		int max = 0;
		int lastMax = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] == N+1) {
				lastMax = max;			
			} else {
				if(ans[A[i]-1] < lastMax){
					ans[A[i]-1] = lastMax;
				}
				ans[A[i]-1] += 1;
				if(ans[A[i]-1] > max) {
					max = ans[A[i]-1];
				} 
			}
		}
		for(int i=0; i<N; i++) {
			if(ans[i] <= lastMax) {
				ans[i] = lastMax;
			}
		}
		return ans;
    }
}