import java.util.*;
class Solution {
    public int solution(int[] A) {
        int N = A.length;
        Map<Integer, Integer> hm = new HashMap<>();
        int cnt = 0;
        for(int i=0; i<N; i++) {
        	int num = Math.abs(A[i]);
            cnt = cnt + 1;
        	if(hm.get(num) == null) {
            	hm.put(num, 1);
            } else {
            	hm.put(num, hm.get(num)+1);
            }
        }
        if(N == 1) {
            return 1;
        }
        for(int key : hm.keySet()) {
        	if(hm.get(key) > 1) {
        		cnt -= hm.get(key) - 1;
        	}
        }
        return cnt;
    }
}