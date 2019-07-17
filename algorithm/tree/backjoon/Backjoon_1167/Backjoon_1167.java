import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
   static class Edge {
      int to;
      int dist;
      Edge(int to, int dist) {
         this.to = to;
         this.dist = dist;
      }
   }
   static ArrayList<Edge> a[];
   static int[][] dist;
   static int n;
   
   public static int[] bfs(int start) {
      boolean[] check = new boolean[n+1];
      int[] dist = new int[n+1];
      Queue<Integer> q = new LinkedList<Integer>();
      check[start] = true;
      q.add(start);
      while(!q.isEmpty()) {
         int x = q.remove();
         for(Edge e : a[x]) {
            int y = e.to;
            int d = e.dist;
            if(check[y] == false) {
               dist[y] = dist[x] + d;
               q.add(y);
               check[y] = true;
            }
         }
      }
      return dist;
   }
   
   public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      
      a = (ArrayList<Edge>[]) new ArrayList[n+1];
      for(int i=1; i<=n; i++) {
         a[i] = new ArrayList<Edge>();
      }
      
      for(int i=1; i<=n; i++) {
         int v = sc.nextInt();
         while(true) {
            int u = sc.nextInt();
            if(u == -1) {
               break;
            }
            int d = sc.nextInt();
            a[v].add(new Edge(u, d));
         }
      }
      int[] dist = bfs(1); // 1부터 나머지 정점까지의 거리 배열
      int start = 1;
      for(int i=2; i<=n; i++) {
         if(dist[i] > dist[start]) {
            start = i;
         }
      }
      dist = bfs(start); // 1~가장 멀었던 정점부터 나머지 정점까지의 거리 배열
      int ans = dist[1];
      for(int i=2; i<=n; i++) {
         ans = Math.max(ans, dist[i]);
      }
      System.out.println(ans);
   }

}