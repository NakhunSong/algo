import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> a[];
	static boolean[] c;
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;
		for(int y : a[x]) {
			if(c[y] == false) {
				dfs(y);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] b = new int[n+1];
			for(int i=1; i<=n; i++) {
				b[i] = sc.nextInt();
			}
			a = (ArrayList<Integer>[]) new ArrayList[n+1];
			for(int i=1; i<=n; i++) {
				a[i] = new ArrayList<Integer>();
			}
			for(int i=1; i<=n; i++) {
				a[i].add(b[i]);
				a[b[i]].add(i);
			}
			c = new boolean[n+1];
			int ans = 0;
			for(int i=1; i<=n; i++) {
				if(c[i] == false) {
					dfs(i);
					ans+=1;
				}
			}
			System.out.println(ans);
		}
	}

}
