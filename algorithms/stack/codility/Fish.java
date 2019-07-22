import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<A.length; i++) {
			if(B[i] == 1 || stack.isEmpty()) { // i가 downstream
				stack.add(i);
			} else {
				boolean win = true;
				while(!stack.isEmpty()) {
					int lastFish = stack.peek();
					if(B[lastFish] == 0) {
						break;
					}
					if(A[lastFish] > A[i]) {
						win = false;
						break;
					} else { // 신입 win
						stack.pop();
					}
				}
				if(win) {
					stack.add(i);
				}
			}
		}
		answer = stack.size();
		return answer;
	
    }
}