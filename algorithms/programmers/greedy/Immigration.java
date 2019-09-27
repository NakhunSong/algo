import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 0;
        long right = (long)n*times[times.length-1];
        answer = right;
        while(left<=right) {
            long mid = (left+right)/2;
            long finished = 0;
            for(int i=0; i<times.length; i++) {
                finished += mid/times[i];
            }
            if(finished >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}