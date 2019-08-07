import java.util.*;
class Solution {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        int left = 0;
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                stack.add(c);
                left++;
            } else {
                if(stack.isEmpty()) {
                    return 0;
                }
                else if(c == '}') {
                    char nowC = stack.pop();
                    if(nowC != '{') return 0; 
                } else if(c == ']') {
                    char nowC = stack.pop();
                    if(nowC != '[') return 0;
                } else if(c == ')') {
                    char nowC = stack.pop();
                    if(nowC != '(') return 0;
                }
                left--;
            }
        }
        if(left != 0) {
        	return 0;
        }
        return 1;
    }
}