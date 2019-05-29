import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
		int cnt = 0;
		for(int i=0; i<n; i++) {
			q.add(new Pair(i, priorities[i]));
		}
		while(!q.isEmpty()) {
			Pair p = q.remove();
			iter = q.iterator();
			boolean biggest = true;
			while(iter.hasNext()) {
				if(p.data < iter.next().data) {
					biggest = false;
				}
			}
			if(biggest) {
				ans[cnt++] = p.idx;
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