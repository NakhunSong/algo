package backjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n+1];
		dp[1] = 1; // 맨 처음은 1로만 시작
		if (n >= 2) {
			dp[2] = 1; // 10 만 가능
		}
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);
	}

}
