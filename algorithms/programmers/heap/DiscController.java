import java.util.*;
class Solution {
	public static class Pair {
		int s;
		int r;
		public Pair(int s, int r) {
			this.s = s;
			this.r = r;
		}
	}
    public int solution(int[][] jobs) {
        int answer = 0;
        List<Pair> list = new ArrayList<>();
        for(int i=0; i<jobs.length; i++) {
        	list.add(new Pair(jobs[i][0], jobs[i][1]));
        }
       	Collections.sort(list, (p1, p2) -> (p1.s - p2.s)); // 요청시간 오름차순 정렬
        PriorityQueue<Pair> q = new PriorityQueue<>((p1, p2) -> p1.r - p2.r); // 처리시간 오름차순     
        int first = list.get(0).s;
        int n = 0;
        for(Pair l : list) {
        	n += l.s + l.r;
        }
        int index = 0;
        int done = 0;
        for(int i=first; i<=n; i++) {
        	while(index < list.size() && i == list.get(index).s) {
        		q.offer(list.get(index));
        		index++;
        	}
        	if(done == 0 && !q.isEmpty()) {
        		Pair p = q.poll();
        		done = p.r;
        		answer += p.r + i - p.s;
        	}
        	if(done > 0) done--;
        }
        return answer/jobs.length;
    }
}