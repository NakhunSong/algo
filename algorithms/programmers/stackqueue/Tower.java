import java.util.*;
class Solution {
    class Pair {
        int idx;
        int height;
        public Pair(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    public int[] solution(int[] heights) {
        int n = heights.length;
        int[] answer = new int[n];
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            int now = heights[i];
            if(stack.isEmpty()) {
                stack.add(new Pair(i+1, now));
                answer[i] = 0;
            } else {
                while(!stack.isEmpty()) {
                    Pair p = stack.peek();
                    if(p.height > now) {
                        answer[i] = p.idx;
                        break;
                    }
                    stack.pop();
                }
                stack.add(new Pair(i+1, now));
            }
        }
        return answer;
    }
}