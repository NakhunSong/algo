package backjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_11057 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 10007;
		int n = Integer.parseInt(br.readLine());
		int[][] d = new int[n+1][10];
		for(int i=0; i<=9; i++) {
			d[1][i] = 1;
		}
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				d[i][j] = 0;
				for(int k=0; k<=j; k++) {
					d[i][j] += d[i-1][k];
				}
				d[i][j] %= mod;
			}
		}
		int ans = 0;
		for(int i=0; i<=9; i++) {
			ans += d[n][i];
		}
		System.out.println(ans%mod);
	}

}
