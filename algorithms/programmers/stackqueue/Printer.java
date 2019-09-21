import java.util.*;

class Solution {
    public static class Pair {
        int idx;
        int data;
        Pair(int idx, int data) {
            this.idx = idx;
            this.data = data;
        }
    }
    public int solution(int[] priorities, int location) {
      int answer = 0;
      Queue<Pair> q = new LinkedList<Pair>();
      Iterator<Pair> iter = null;
      int n = priorities.length;
      int[] ans = new int[n];
      int idx = 0;
      for(int i=0; i<n; i++) {
        q.add(new Pair(i, priorities[i]));
      }
      while(!q.isEmpty()) {
        Pair p = q.remove();
        iter = q.iterator();
        boolean ok = true;
        while(iter.hasNext()) {
          if(p.data < iter.next().data) {
            ok = false;
          }
        }
        if(ok) {
          ans[idx++] = p.idx;
        } else {
          q.add(p);
        }
      }
      for(int i=0; i<ans.length; i++) {
        if(ans[i] == location) {
          answer = i+1;
        }
      }
      return answer;
    }
}