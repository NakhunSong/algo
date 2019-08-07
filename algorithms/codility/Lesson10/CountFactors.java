class Solution {
    public int solution(int N) {
        int sqrtN = (int)Math.sqrt(N);
        int cnt = 0;
        for(int i=1; i<=sqrtN; i++) {
            if(N%i == 0) {
                cnt+=2;
            }
        }
        if(sqrtN * sqrtN == N) {
            cnt -= 1;
        }
        return cnt;
    }
}