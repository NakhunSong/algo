import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Set<Integer> rSet = new HashSet<>();
        for(int i=0; i<reserve.length; i++) {
            rSet.add(reserve[i]);
        }
        Set<Integer> lSet = new HashSet<>();
        for(int i=0; i<lost.length; i++) {
            if(rSet.contains(lost[i])) {
                rSet.remove(lost[i]);
            } else {
                lSet.add(lost[i]);
            }
        }
        for(int i=1; i<=n; i++) {
            if(lSet.contains(i)) {
                if(rSet.contains(i-1)) {
                    rSet.remove(i-1);
                    lSet.remove(i);
                }
            }
            if(lSet.contains(i)) {
                if(rSet.contains(i+1)) {
                    rSet.remove(i+1);
                    lSet.remove(i);
                }
            }
        }
        return answer-lSet.size();
    }
}