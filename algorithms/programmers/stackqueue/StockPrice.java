import java.util.*;
class Solution {
    class Pair {
        int start;
        int price;
        public Pair(int start, int price) {
            this.start = start;
            this.price = price;
        }
    }
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty()) {
                Pair pre = stack.peek();
                if(pre.price > prices[i]) {
                    answer[pre.start] = i-pre.start;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.add(new Pair(i, prices[i]));
        }
        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            answer[p.start] = (n-1) - p.start;
        }
        return answer;
    }
}