import java.util.*;

public class Main {
	public static int[] parent;
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		} else {
			int y = find(parent[x]);
			parent[x] = y;
			return y;
		}
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			parent[y] = x;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n+1];
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		for(int i=0; i<m; i++) {
			int q = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(q == 0) {
				union(a, b);				
			} else if(q == 1) {
				if(find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");					
				}
			}
		}
	}
}
