import java.util.Arrays;
class Solution {
    public int solution(int[] A) {
        int answer = 0; 
        int N = A.length;
        for(int i=0; i<=N-2; i++) {
            for(int j=i+1; j<=N-1; j++) {
                int dist = j-i;
                if(A[i]+A[j] > dist) {
                    answer++;
                }
            }
        }
        return answer;
    }
}