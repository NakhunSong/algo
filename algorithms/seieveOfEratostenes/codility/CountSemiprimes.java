class Solution {
    public int[] solution(int N, int[] P, int[] Q) {int[] prime = new int[N+1];

		int sqrtN = (int)Math.sqrt(N);
		for(int i=2; i<=sqrtN; i++) {
			if(prime[i] == 0) { // 소수라면
				for(int j=i+i; j<=N; j+=i) {
					
					prime[j] = i;
				}
			}
		}
		int[] semiPrimesCnt = new int[N+1];
		for(int i=2; i<=N; i++) {
			semiPrimesCnt[i] = semiPrimesCnt[i-1];
			if(prime[i] != 0) {
				if(prime[i/prime[i]] == 0) {
					semiPrimesCnt[i]++;
				}
			}
		}
		int M = P.length;
		int[] answer = new int[M];
		for(int i=0; i<M; i++) {
			answer[i] = semiPrimesCnt[Q[i]] - semiPrimesCnt[P[i]-1];
		}
		return answer;
    }
}