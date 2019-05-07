import java.util.Scanner;

public class Main {
	static int[] dp;
	public static int go(int n) {
		if(dp[n] > 0) return dp[n];
		dp[n] = go(n-1) + go(n-2);
		return dp[n]%=10007;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		System.out.println(go(N));
	}

}
