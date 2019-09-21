import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
		int[] answer = {0,0};
		PriorityQueue<Integer> maxq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
		PriorityQueue<Integer> minq = new PriorityQueue<>();
		for(int i=0; i<operations.length; i++) {
			String word = operations[i];
			if(word.charAt(0) == 'I') {
				int num = Integer.valueOf(word.substring(2));
				maxq.add(num);
				minq.add(num);
			} else {
				if(!maxq.isEmpty()) {
					if(word.equals("D -1")) {
						int min = minq.remove();
						maxq.remove(min);
					} else {
						int max = maxq.remove();
						minq.remove(max);
					}					
				}
			}
				
		}
		if(!maxq.isEmpty()) {
			answer[0] = maxq.remove();
			answer[1] = minq.remove();
		}
		return answer;
    }
}