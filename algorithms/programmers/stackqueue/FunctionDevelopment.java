import java.util.*;

class Solution {
	class Pair {
		int index;
		int progress;
		public Pair(int index, int progress) {
			this.index = index;
			this.progress = progress;
		}
	}
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            q.add(new Pair(i, progresses[i]));
        }
        Iterator<Pair> iter = null;
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            iter = q.iterator();
            int index = 0;
            q = new LinkedList<>();
            while(iter.hasNext()) {
                Pair p = iter.next();
                p.progress += speeds[p.index];
                q.add(p);
            }
            iter = q.iterator();
            int deploy = 0;
            while(!q.isEmpty()) {
                if(q.peek().progress >= 100) {
                    q.remove();
                    deploy++;
                } else {
                    break;
                }
            }
            if(deploy > 0) {
                list.add(deploy);
            }
        }
        int[] answer = new int[list.size()];
        int i = 0;
        for(int l : list) {
        	answer[i++] = l;
        }
        return answer;
    }
}