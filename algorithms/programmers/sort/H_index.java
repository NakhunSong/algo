import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] list = new Integer[citations.length];
        for(int i=0; i<citations.length; i++) {
        	list[i] = citations[i];
        }
        Arrays.sort(list, Collections.reverseOrder());
        for(int i=0; i<list.length; i++) {
            if(list[i] <= i) {
                answer = i;
                break;
            }
        }
        if(list[0] != 0 && answer == 0) {
        	answer = list.length;
        }
        return answer;
    }
}