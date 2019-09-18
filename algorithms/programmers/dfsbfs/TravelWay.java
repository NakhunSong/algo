import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static int n;
    static void dfs(String[][] tickets, boolean[] check, int index, int cnt, String result) {
        if(cnt == n) {
            list.add(result);
            return;
        }
        String now = tickets[index][1];
        for(int i=0; i<n; i++) {
            if(!check[i]) {
                check[i] = true;
                if(now.equals(tickets[i][0])) {
                    dfs(tickets, check, i, cnt+1, result+tickets[i][1]);
                }
                check[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
         n = tickets.length;
        for(int i=0; i<n; i++) {
            if("ICN".equals(tickets[i][0])) {
            	boolean[] check = new boolean[n];
                check[i] = true;
                dfs(tickets, check, i, 1, tickets[i][0]+tickets[i][1]);
            }
        }
        Collections.sort(list);
        String[] answer = new String[n+1];
        int index = 0;
        String result = list.get(0);
        String s = "";
        for(int i=0; i<result.length(); i++) {
        	s += result.charAt(i);
        	if(i%3 == 2) {
        		answer[index++] = s;
        		s = "";
        	}
        }
        
        return answer;
    }
}