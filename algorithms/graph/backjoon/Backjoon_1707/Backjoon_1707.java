import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> a[];
	static int color[];
	public static boolean dfs(int x, int c) {
		color[x] = c;
		for(int y : a[x]) {
			if(color[y] == 0) {
				if(dfs(y, 3-c) == false) {
					return false;
				}
			} else if(color[y] == color[x]) {
				return false;	
			}
		}
		return true;
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
			boolean ok = true;
			for(int i=1; i<=v; i++) {
				if(color[i] == 0) {
					if(dfs(i, 1) == false) {
						ok = false;						
					}
				}
			}
			
			System.out.println(((ok) ? "YES" : "NO"));
		}
	}

}
