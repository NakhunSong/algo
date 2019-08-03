import java.util.*;
class Solution {
    public int solution(int[] A) {
		int answer = 0;
		int N = A.length;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<N-1; i++) {
			if(A[i]>A[i-1] && A[i] > A[i+1]) {
				list.add(i);
			}
		}
		if(list.size() <2 ) {
			return list.size();
		}
		int flags = 1;
		while(flags <= list.size()) {
			boolean ok = false;
			int start = list.get(0);
			int cnt = 1;
			for(int i=1; i<list.size(); i++) {
				if(start + flags <= list.get(i)) {
					cnt++;
					start = list.get(i);
				}
				if(cnt>=flags) {
					ok = true;
					break;
				}
			}
			if(ok) {
				answer = flags;
				flags++;
			} else {
				break;
			}
		}
		return answer;
    }
}
// 80%