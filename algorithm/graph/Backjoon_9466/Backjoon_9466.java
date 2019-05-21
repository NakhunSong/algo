import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[] a;
	static int[] c;
	static int[] round;
	
	public static int dfs(int x, int cnt, int r) {
		if(c[x]!=0) {
			if(round[x] != r) {
				return 0;				
			}
			return cnt-c[x];
		}
		c[x] = cnt;
		round[x] = r;
		return dfs(a[x], cnt+1, r);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			a = new int[n+1];
			for(int i=1; i<=n; i++) {
				a[i] = sc.nextInt();
			}
			c = new int[n+1];
			round = new int[n+1];
			int ans = 0;
			for(int i=1; i<=n; i++) {
				if(c[i] == 0) {
					ans += dfs(i, 1, i);
				}
			}
			
			System.out.println(n-ans);
		}
	}

}
