public boolean solution(String s) {
    boolean answer = true;
    s = s.toUpperCase();
    int p = 0;
    int y = 0;
    for(int i=0; i<s.length(); i++) {
        char c = s.charAt(i);
        if(c == 'P') {
            p += 1;
        } else if(c == 'Y') {
            y += 1;
        }
    }
    if(p != y) {
        answer = false;
    }
    return answer;
}