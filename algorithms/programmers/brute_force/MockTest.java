import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        Queue<Integer> q = new LinkedList<>();
        int p1 = 0, p2 = 0, p3 = 0;
        int max = 0;
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<answers.length; i++) {
            int a = answers[i];
            if(one[i%5] == a) {
                p1++;
            }
            if(two[i%8] == a) {
                p2++;
            }
            if(three[i%10] == a) {
                p3++;
            }
            max = Math.max(p3, Math.max(p1, p2));
        }
        if(max == p1) {
            q.add(1);
        }
        if(max == p2) {
            q.add(2);
        }
        if(max == p3) {
            q.add(3);
        }
        int index = 0;
        int n = q.size();
        answer = new int[n];
        while(!q.isEmpty()) {
        	answer[index++] = q.remove();
        }
        return answer;
    }
}