import java.util.HashSet;
import java.util.Set;

public int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;
    Set<Integer> set = new HashSet<>();
    int totalCnt = reserve.length;
    for(int i=0; i<reserve.length; i++) {
        int front = reserve[i]-1;
        int back = reserve[i]+1;
        if(front>=1) {
            set.add(front);
        }
        if(back<=n) {
            set.add(back);              
        }
    }
    System.out.println(set.size());
    for(int i=0; i<lost.length; i++) {
        if(set.contains(lost[i]) && totalCnt>=1) {
            set.remove(lost[i]);
            totalCnt -= 1;
        }
    }
    System.out.println(set.size());
    int tmp = set.size();
    tmp = lost.length-tmp;
    answer = n - tmp;
    return answer;
}