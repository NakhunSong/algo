import java.util.*;
class Solution {
    public boolean check(int[] A, int p, int q, int r) {
		if((long)(A[p]+A[q]) > (long)A[r]) {
			return true;
		}
		return false;
	}
    public int solution(int[] A) {
		Arrays.sort(A);
		int N = A.length;
		
		int cnt = 0;
		for(int i=0; i<N-2; i++) {
			int p = i;
			int q = i+1;
			int r = i+2;
			while(r < N) {
				if(check(A, p, q, r)) {
					cnt += r-q;
					r++;
				} else if(q < r) {
					q++;
				}
			}
		}
		return cnt;
    }
}