import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> a[];
	static boolean check[];
	
	public static void dfs(int x) {
		if(check[x]) {
			return;
		}
		check[x] = true;
		for(int i=0; i<a[x].size(); i++) {
			int y = a[x].get(i);
			if(check[y] == false) {
				dfs(y);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		a = (ArrayList<Integer>[]) new ArrayList [n+1];
		
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
		
		int ans = 0;
		check = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			if(check[i] == false) {
				dfs(i);
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
