package backjoon.dp;

import java.util.Scanner;

public class B_2193_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] d = new long[n+1][2];
		d[1][0] = 0;
		d[1][1] = 1;
		for(int i=2; i<=n; i++) {
			d[i][0] = d[i-1][1] + d[i-1][0];
			d[i][1] = d[i-1][0];
		}
		
		long ans = 0;
		for(int i=0; i<=1; i++) {
			ans += d[n][i];
		}
		System.out.println(ans);
	}

}
