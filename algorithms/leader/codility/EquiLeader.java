import java.util.HashMap;
class Solution {
    public int solution(int[] A) {
        int answer = 0;
        int N = A.length;
        int leader = 0;
        int leaderCount = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++) {
            if(hm.get(A[i]) == null) {
                hm.put(A[i], 1);
            } else {
                int count = hm.get(A[i]) + 1;
                hm.put(A[i], count);
                if(count > leaderCount) {
                    leader = A[i];
                    leaderCount = count;
                }
            }
        }
        int leftLeaderCount = leaderCount;
        int rightLeaderCount = 0;
        for(int i = N-1; i>=0; i--) {
            if(A[i] == leader) {
                leftLeaderCount--;
                rightLeaderCount++;
            }
            if(leftLeaderCount>i/2 && rightLeaderCount>(N-i)/2) {
                answer++;
            }
        }
        return answer;
    }
}
`