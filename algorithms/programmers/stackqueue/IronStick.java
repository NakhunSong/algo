import java.util.*;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        char last = arrangement.charAt(0);
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<arrangement.length(); i++) {
            char c = arrangement.charAt(i);
            if(c == '(') {
                stack.add(c);
            } else {
                stack.pop();    
                if(last == ')') {
                    answer += 1;
                } else {
                    answer += stack.size();   
                }
            }
            last = c;
        }
        return answer;
    }
}