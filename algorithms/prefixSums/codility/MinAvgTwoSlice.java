class Solution {
    public int solution(int[] A) {
		int N = A.length;
		float minAvg = (float)(A[0]+A[1])/2;
		int startIdx = 0;
		for(int i=0; i<N-2; i++) {
			float avg2 = (float)(A[i]+A[i+1])/2;
			float avg3 = (float)(A[i] + A[i+1] + A[i+2])/3;
			float newMinAvg = Math.min(avg2, avg3);
			if(minAvg > newMinAvg) {
				minAvg = newMinAvg;
				startIdx = i;
			}
		}
		float lastAvg = (float)(A[N-2]+A[N-1])/2;
		if(minAvg > lastAvg) {
			startIdx = N-2;
		}
		return startIdx;
    }
}