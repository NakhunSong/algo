import java.util.*;
class Solution {
    public int solution(int[] A) {
		int N = A.length;
		Arrays.sort(A);
		if(N == 1) {
			return Math.abs(A[0]*2);
		}
		int left = 0;
		int right = N-1;
		int min = Math.abs(A[left] + A[right]);
		while(left<=right) {
			int now = Math.abs(A[left] + A[right]);
			if(min > now) {
				min = now;
			}
			if(Math.abs(A[left]) > Math.abs(A[right])) {
				left++;
			} else if(Math.abs(A[left]) <= Math.abs(A[right])){
				right--;
			}
		}
		return min;
    }
}