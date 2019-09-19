import java.util.*;

class Solution {
    static boolean check(Iterator<Integer> iter, int K) {
        while(iter.hasNext()) {
            if(iter.next() < K) {
                return false;
            }
        }
        return true;
    }
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int answer = -1;
        for(int i=0; i<scoville.length; i++) {
            q.offer(scoville[i]);
        }
        int cnt = 0;
        Iterator<Integer> iter = q.iterator();
        if(check(iter, K)) {
            answer = cnt;
            return answer;
        }
        while(q.size() > 0) {
            cnt++;
        	int first = q.poll();
            int second;
            if(q.isEmpty()) {
                break;
            } else {
                second = q.poll();
            }
            int n = first + second*2;
            q.offer(n);
            iter = q.iterator();
            if(check(iter, K)) {
                answer = cnt;
                break;
            }
        }
        return answer;
    }
}