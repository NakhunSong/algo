package backjoon.dp;

import java.util.Scanner;

public class B_2193 {
	public static long[] d;
	public static long go(int n) {
		if(n <= 2) return 1;
		if(d[n]>0) return d[n];
		d[n] = go(n-1) + go(n-2);
		return d[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new long[n+1];
		
		System.out.println(go(n));
	}
}