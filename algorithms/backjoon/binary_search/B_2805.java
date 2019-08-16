import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static boolean check(long[] a, long n, long m, long mid) {
		long sum = 0;
		for(int i=0; i<n; i++) {
			if(a[i]-mid > 0) {
				sum += (a[i]-mid);
			}
		}
		if(sum>=m) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.valueOf(s[0]);
		long m = Integer.valueOf(s[1]);
		long[] a = new long[n];
		String[] k = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			a[i] = Long.valueOf(k[i]);
		}
		long max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, a[i]);
		}
		long left = 0;
		long right = max;
		long ans = 0;
		while(left<=right) {
			long mid = (left+right)/2;
			if(check(a, n, m, mid)) {
				ans = Math.max(ans, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}
