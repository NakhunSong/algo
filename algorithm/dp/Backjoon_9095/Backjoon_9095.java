import java.util.Scanner;

public class Main {
    public static int[] dp = new int[11];
    public static int go(int n) {
        if(n<0) return 0;
        if(n<=1) return 1;
        if(dp[n]>0) return dp[n];
        dp[n] = go(n-1) + go(n-2) + go(n-3);
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ans = new int[t];
        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            ans[i] = go(n);
        }
        for(int i=0; i<t; i++) {
            System.out.println(ans[i]);
        }
    }
}