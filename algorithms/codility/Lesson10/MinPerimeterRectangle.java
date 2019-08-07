class Solution {
    public int solution(int N) {
        int sqrtN = (int)Math.sqrt(N);
        int answer = 0;
        for(int i=sqrtN; i>=1; i--) {
            if(N % i == 0) {
                answer = i;
                break;
            }
        }
        int opposite = N/answer;
        answer = (answer+opposite)*2;
        return answer;
    }
}