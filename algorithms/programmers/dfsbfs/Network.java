import java.util.*;

class Solution {
    static boolean[] check;
    static ArrayList<Integer>[] a;
    static void dfs(int x) {
        if(check[x] == true) return;
        check[x] = true;
        for(int l : a[x]) {
            dfs(l);
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];
        a = (ArrayList<Integer>[])new ArrayList[n];
        for(int i=0; i<n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1) {
                    a[i].add(j);
                }
            }
        }
        for(int i=0; i<n; i++) {
            if(check[i] == false) {
                dfs(i);
                answer++;   
            }
        }
        return answer;
    }
}