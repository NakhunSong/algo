import java.util.Arrays;
class Solution {
    public int solution(int[] A) {
        int answer = 0;
        int N = A.length;
        Arrays.sort(A);
        for(int i=1; i<=N-2; i++) {
            if((long)A[N-i] < (long)A[N-i-1] + (long)A[N-i-2]) {
                answer = 1;
            }
        }
        return answer;
    }
}