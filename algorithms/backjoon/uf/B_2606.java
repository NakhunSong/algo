import java.util.*;

public class Main {
	public static int[] parent;
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}
	public static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x != y) {
			parent[y] = x;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a, b);
		}
		int cnt = 0;
		for(int i=2; i<=n; i++) {
			if(find(i) == find(1)) {
				cnt+=1;
			}
		}
		System.out.println(cnt);
	}

}
