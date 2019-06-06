import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
		int answer = 0;
		int n = clothes.length;
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i=0; i<n; i++) {
			Integer value = hm.get(clothes[i][1]);
			if(value == null) {
				hm.put(clothes[i][1], 1);
			} else {
				value+=1;
				hm.put(clothes[i][1], value);
			}
		}
		
		return answer;
    }
}