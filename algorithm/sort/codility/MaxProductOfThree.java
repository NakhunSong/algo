import java.util.Arrays;
class Solution {
    public int solution(int[] A) {
        int answer = 0;
        int N = A.length;
        Arrays.sort(A);
        int minus = A[0] * A[1] * A[N-1];
        int plus = A[N-1] * A[N-2] * A[N-3];
        if(minus > plus) {
            answer = minus;
        } else {
            answer = plus;
        }
        return answer;
    }
}
