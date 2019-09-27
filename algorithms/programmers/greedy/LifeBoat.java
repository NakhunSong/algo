import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = people.length;
        int end = people.length-1;
        Arrays.sort(people);
        int cnt = 0;
        for(int i=0; i<=end; i++) {
            for(int j=end; j>=i+1; j--) {
                end--;
                if(people[i]+people[j] <= limit) {
                    cnt++;
                    break;
                }
            }
        }
        answer -= cnt;
        return answer;
    }
}