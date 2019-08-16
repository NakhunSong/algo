import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int n, m;
	public static int start, end;
	public static boolean check[];
	
	public static class Pair {
		int next;
		int w;
		public Pair(int next, int w) {
			this.next = next;
			this.w = w;
		}
	}
	public static ArrayList<Pair> a[];
	
	public static boolean go(int node, int limit) {
		if(check[node]) {
			return false;
		}
		check[node] = true;
		if(node == end) {
			return true;
		}
		for(Pair p : a[node]) {
			int next = p.next;
			int w = p.w;
			if(w>=limit) {
				if(go(next, limit)) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = (ArrayList<Pair>[])new ArrayList[n+1];
		check = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		int max = 0;
		for(int i=0; i<m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int w = sc.nextInt();
			a[s].add(new Pair(e, w));
			a[e].add(new Pair(s, w));
			max = Math.max(max, w);
		}
		start = sc.nextInt();
		end = sc.nextInt();
		
		int left = 1;
		int right = max;
		int ans = 0;
		while(left<=right) {
			int mid = (left+right)/2;
			Arrays.fill(check, false);
			if(go(start, mid)) {
				ans = Math.max(ans, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}
