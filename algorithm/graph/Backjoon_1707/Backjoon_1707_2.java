import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> a[];
	static int color[];
	public static void dfs(int x, int c) {
		if(color[x] != 0) {
			return;
		}
		color[x] = c;
		for(int y : a[x]) {
			if(color[y] == 0) {
				dfs(y, 3-c);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			a = (ArrayList<Integer>[]) new ArrayList[v+1];
			for(int i=1; i<=v; i++) {
				a[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<e; i++) {
				int u = sc.nextInt();
				int w = sc.nextInt();
				a[u].add(w);
				a[w].add(u);
			}
			color = new int[v+1];
			for(int i=1; i<=v; i++) {
				if(color[i] == 0) {
					dfs(i, 1);
				}
			}
			boolean ok = true;
			for(int i=1; i<=v; i++) {
				for(int j : a[i]) {
					if(color[i] == color[j]) {
						ok = false;
					}
				}
			}
			System.out.println(((ok) ? "YES" : "NO"));
		}
	}

}
