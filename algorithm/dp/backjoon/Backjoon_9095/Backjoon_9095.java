package backjoon.dp;

import java.util.Scanner;

public class B_9095 {
	public static int[] d;
	public static int go(int n) {
		if(n<0) return 0;
		if(n <= 1) return 1;
		if(d[n] > 0) return d[n];
		d[n] = go(n-1) + go(n-2) + go(n-3);
		return d[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			d = new int[n+1];
			System.out.println(go(n));
		}
	}

}
