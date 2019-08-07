package backjoon.dp;

import java.util.Scanner;

public class B_2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		long[][] d = new long[n+1][3];
		for(int i=1; i<=n; i++) {
			d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
			d[i][1] = d[i-1][0] + a[i];
			d[i][2] = d[i-1][1] + a[i];
		}
		long ans = 0;
		ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
		System.out.println(ans);
	}

}
