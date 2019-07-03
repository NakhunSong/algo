import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
		int answer = 0;
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i<A.length; i++) {
			if(hm.get(A[i]) == null) {
				hm.put(A[i], 1);				
			} else {
				int cnt = hm.get(A[i])+1;
				hm.put(A[i], cnt);
			}
		}
		for(int key : hm.keySet()) {
			if(hm.get(key) % 2 != 0) {
				answer = key;
			}
		}
		return answer;
    }
}