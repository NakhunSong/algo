import java.util.*;
class Pair implements Comparable<Pair> {
    double rate;
    int index;
    public Pair(double rate, int index){
        this.rate = rate;
        this.index = index;
    }
    @Override
    public int compareTo(Pair p){
        if(this.rate < p.rate){
            return 1;
        } else if(this.rate > p.rate) {
            return -1;
        } else if(this.rate == p.rate){
            if(this.index > p.index) {
                return 1;
            } else if(this.index < p.index) {
                return -1;
            }
        }
        return 0;
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] cnt = new int[N+1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=N; i++){
            for(int s : stages) {
                if(s>=i) {
                    cnt[i] += 1;
                }
            }
        }
        for(int s : stages) {
        	if(!(s == N+1)) {
        		if(map.containsKey(s)) {
        			map.put(s, map.get(s)+1);
        		} else {
        			map.put(s, 1);
        		}        		
        	}
        }
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            double rate = 0;
            if(cnt[i] != 0) {
            	if(map.containsKey(i)) {
            		rate = map.get(i);
            	}
            }
            rate = rate/cnt[i];
            list.add(new Pair(rate, i));
        }
        Collections.sort(list);
        int[] answer = new int[N];
        int index = 0;
        for(Pair p : list) {
        	answer[index++] = p.index;
        }
        return answer;
    }
}