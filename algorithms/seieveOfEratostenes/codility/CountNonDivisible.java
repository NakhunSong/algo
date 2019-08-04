class Solution {
    public int[] solution(int[] A) {
        int N = A.length;
        int[] numCnt = new int[N*2+1];
        for(int num : A) {
            numCnt[num]++;
        }
        int[] divisors = new int[N*2+1];
        for(int i=1; i*i<divisors.length; i++) {
            for(int j=i*i; j<divisors.length; j+=i) {
                divisors[j] += numCnt[i]; // 제곱수 체크
                if(j != i*i) {
                    divisors[j] += numCnt[j/i]; // 배수 체크
                }
            }
        }
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = N-divisors[A[i]];
        }
        return answer;
    }
}