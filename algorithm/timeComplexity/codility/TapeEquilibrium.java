import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        int answer = 0;
        int total = A[0];
        int N = A.length - 1;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=1; i<=N; i++) {
            hm.put(i, total);
            total += A[i];
        }
        answer = Math.abs(hm.get(1) - (total - hm.get(1)));
        for(int i=2; i<=N; i++) {
            int num = (total - hm.get(i));
            num = Math.abs(hm.get(i) - num);
            answer = Math.min(answer, num);
        }
        return answer;
    }
}