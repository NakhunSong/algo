```
import java.util.*;
class Solution {
    public int solution(int[] H) {
		Stack<Integer> stack = new Stack<>();
		int total = H[0];
		int newBlock = H[0];
		int cnt = 0;
		stack.add(newBlock);
		for(int i=1; i<H.length; i++) {
			if(H[i] < total) {
				while(!stack.isEmpty()) {
					total -= stack.pop();
					cnt++;
					if(H[i] > total) {
						newBlock = H[i] - total;
						stack.add(newBlock);
						total = H[i];
						break;
					} else if(H[i] == total) {
						break;
					}
				}
			} else if(H[i] > total) {
				newBlock = H[i] - total;
				stack.add(newBlock);
				total = H[i];
			}
		}
		while(!stack.isEmpty()) {
			stack.pop();
			cnt++;
		}
		return cnt;
    }
}
```