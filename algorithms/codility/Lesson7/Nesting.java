import java.util.Stack;
public int solution(String S) {
  Stack<Character> stack = new Stack<>();
  for(int i=0; i<S>length(); i++) {
    if(S.charAt(i) == '(') {
      stack.add(S.charAt(i));
    } else {
      if(!stack.isEmpty()) {
        stack.pop();
      } else {
        return 0;
      }
    }
  }
  if(!stack.isEmpty()) {
    return 0;
  }
  return 1;
}