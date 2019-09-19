import java.util.*;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
      int answer = 0;
      PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
      int idx = 0;
      for(int i=0; i<k; i++) {
        if(idx < dates.length && i == dates[idx]) {
          q.offer(supplies[idx]);
          idx++;
        }
        if(stock == 0) {
          stock += q.poll();
          answer++;
        }
        stock--;
      }
		return answer;
    }
}


// fail 
//import java.util.*;
class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
      int n = dates.length;
      Queue<Integer> q = new LinkedList<>();
      for(int i=0; i<n; i++) {
        q.add(i);
      }
      int cnt = 0;
      while(!q.isEmpty()) {
        int idx = q.poll();
        stock -= dates[idx];
        k -= dates[idx];
        if(q.isEmpty()) {
          break;
        }
        int nidx = q.peek();
        if(stock+supplies[idx] >= k-1) {
          cnt++;
          break;
        } else {
          if(stock-dates[nidx] <= 0) {
            stock += supplies[idx];
            cnt++;
          }
        }
      }
      return cnt;
    }
}