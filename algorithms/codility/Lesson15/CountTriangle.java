import java.util.*;
class Solution {
    public static boolean check(int[] A, int p, int q, int r) {
		if((long)(A[p]+A[q]) > (long)A[r]) {
			return true;
		}
		return false;
	}
    public int solution(int[] A) {
		int cnt = 0;
		Arrays.sort(A);
		int N = A.length;
		for(int i=0; i<N-2; i++) {
			int p = i;
			int q = i+1;
			int r = i+2;
			while(q < N) {
				if(r<N && check(A, p, q, r)) {
					r++;
				}
				else {
					cnt += r-q-1;
					q++;
				}
			}
		}
		return cnt;
    }
}