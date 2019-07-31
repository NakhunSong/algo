import java.util.*;
class Solution {
    public int solution(int[] A) {
        int answer = 0;
        int N = A.length;
        ArrayList<Integer> idxList = new ArrayList<>();
        for(int i=1; i<N-1; i++) {
            if(A[i-1] < A[i] && A[i] > A[i+1]) {
            	idxList.add(i);
            }
        }
        for(int i=N/2; i>=1; i--) {
            if(N % i == 0) {
            	int blockIdx = 0;
            	int blockSize = N/i;
            	for(int k=0; k<idxList.size(); k++) {
            		int num = idxList.get(k);
            		if(num/blockSize == blockIdx) {
            			blockIdx++;
            		}
            	}
            	if(blockIdx == i) {
            		answer = i;
            		break;
            	}
            }
        }
        return answer;
    }
}