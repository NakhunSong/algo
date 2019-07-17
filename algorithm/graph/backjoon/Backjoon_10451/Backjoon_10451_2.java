import java.util.Scanner;

public class Main {
	static int[] a;
	static boolean[] c;
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;
		dfs(a[x]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			a = new int[n+1]; 
			for(int i=1; i<=n; i++) {
				a[i] = sc.nextInt(); // 순열 사이클은 한 정점이 다음 정점 한개만을 갖는다.
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
