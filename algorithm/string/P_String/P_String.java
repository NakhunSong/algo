public String solution(String s) {
    String answer = "";
    int n = s.length();
    int idx = n/2;
    if(n%2==0) {
        answer += s.charAt(idx-1);
        answer -= s.charAt(idx);
    } else {
        answer += s.charAt(idx);
    }
    return answer;
}