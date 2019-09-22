import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int n = truck_weights.length;
        int index = 0;
        int time = 0;
        int cnt = 0;
        while(cnt<bridge_length) {
            q.add(0);
            cnt++;
        }
        System.out.println(q.size());
        int now = 0;
        while(!q.isEmpty()) {
            int left = q.remove();
            now -= left;
            if(index < n && now+truck_weights[index] <= weight) {
                q.add(truck_weights[index]);
                now += truck_weights[index];
                if(index<n) {
                    index++;
                }
            } else {
                if(index<n) {
                    q.add(0);   
                }
            }
            
            time++;
        }
        return answer=time;
    }
}

// 이전 솔루션
class Solution {
    public static class truck {
        int weight;
        int idx;

        public truck(int weight, int idx) {
            this.weight = weight;
            this.idx = idx;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<truck> ready = new LinkedList<truck>();
        Queue<truck> bridge = new LinkedList<truck>();
        Queue<truck> finished = new LinkedList<truck>();

        for(int i=0; i<truck_weights.length; i++) {
            ready.add(new truck(truck_weights[i], 0));
        }
        int weightSum = 0;
        answer += 1;
        while(finished.size() < truck_weights.length) {
            int bridgeWeight = 0;
            if(!ready.isEmpty()) {
                bridgeWeight = weightSum + ready.peek().weight;
                if(bridgeWeight <= weight) {
                    truck t = ready.remove();
                    weightSum += t.weight; // 무게 추가
                    bridge.add(new truck(t.weight, answer-1)); // 다리에 트럭 넣음
                }               
            }
            int time = answer - bridge.peek().idx;
            if(time == bridge_length) {
                truck t = bridge.remove();
                weightSum -= t.weight;
                finished.add(t);
            }
            answer+=1; // 1초후
        }

        return answer;
    }
}