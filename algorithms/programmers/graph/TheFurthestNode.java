import java.util.*;

class Solution {
    static ArrayList<Integer>[] v;
    static boolean[] check;
    static int[] d;
    static void bfs(int node) {
        if(check[node]) return;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        check[node] = true;
        d[node] = 0;
        while(!q.isEmpty()) {
            int x = q.remove();
            for(int i : v[x]) {
                if(check[i] == false) {
                    check[i] = true;
                    d[i] = d[x] + 1;
                    q.add(i);
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        v = (ArrayList<Integer>[])new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            v[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            v[a].add(b);
            v[b].add(a);
        }
        d = new int[n+1];
        check = new boolean[n+1];
        bfs(1);
        
        int max = 0;
        int cnt = 0;
        for(int i : d) {
            if(max < i) {
                max = i;
                cnt = 1;
            } else if(max == i) {
                cnt++;
            }
        }
        return cnt;
    }
}