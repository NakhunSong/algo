public int solution(String str) {
    int answer = 0;
    if(str.charAt(0) == '-') {
        str = str.substring(1);
        answer = Integer.parseInt(str);
        answer *= -1;
    } else {
        answer = Integer.parseInt(str);
    }
    return answer;
}