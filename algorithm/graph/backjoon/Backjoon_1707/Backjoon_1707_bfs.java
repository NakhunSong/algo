import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> a[];
	public static void bfs(int[] check, int start, int cnt) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = cnt;
		while(!q.isEmpty()) {
			int x = q.remove();
			for(int y : a[x]) {
				if(check[y] == 0 && check[x] != 0) {
					check[y] = 3 - check[x];
					q.add(y);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		while(k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			a = (ArrayList<Integer>[])new ArrayList[n+1];
			for(int i=1; i<=n; i++) {
				a[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				a[u].add(v);
				a[v].add(u);
			}
			int[] check = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				if(check[i] == 0) {
					bfs(check, i, 1);
				}
			}
			boolean ans = true;
			for(int i=1; i<=n; i++) {
				for(int x : a[i]) {
					if(check[i] == check[x]) {
						ans = false;
					}
				}
			}
			if(ans) {
				System.out.println("YES");				
			} else {
				System.out.println("NO");
			}
		}
	}

}
