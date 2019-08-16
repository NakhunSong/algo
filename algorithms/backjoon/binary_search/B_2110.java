import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static boolean check(int n, long[] a, long c, long max) {
		int cnt = 1;
		long last = a[0];
		for(int i=1; i<n; i++) {
			if(a[i]-last >= max) {
				last = a[i];
				cnt++;
			}
		}
		if(cnt>=c) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long c = sc.nextInt();
		long[] a = new long[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		long left = 1;
		long right = a[n-1]-a[0];
		long ans = 0;
		while(left<=right) {
			long mid = (left+right)/2;
			if(check(n, a, c, mid)) {
				ans = Math.max(ans, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}
