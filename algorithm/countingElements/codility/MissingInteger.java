import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        int ans = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            if(hm.get(A[i]) == null) {
                hm.put(A[i], 1);
            }            
        }
        for(int i=1; i<=1000000; i++) {
            if(hm.get(i) == null) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}