import java.util.Scanner;

public class Main {
	public static int n;
	public static int k;
	public static long[] a;
	public static boolean check(long mid) {
		int cnt = 0;
		for(int i=0; i<k; i++) {
			cnt += (a[i]/mid);
		}
		return cnt>=n;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		a = new long[k];
		long max = 0;
		for(int i=0; i<k; i++) {
			a[i] = sc.nextInt();
			max = Math.max(max, a[i]);
		}
		long left = 1;
		long right = max;
		long ans = 0;
		while(left <= right) {
			long mid = (left+right)/2;
			if(check(mid)) {
				ans = Math.max(ans, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}
