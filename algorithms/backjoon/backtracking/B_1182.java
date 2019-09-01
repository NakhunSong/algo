import java.io.*;
import java.util.*;

public class Main {
	public static int cnt = 0;
	public static void go(int[] a, int s, int index, int sum) {
		if(index == a.length) {
			if(sum == s) {
				cnt += 1;
			}
			return;
		}
		go(a, s, index+1, sum + a[index]);
		go(a, s, index+1, sum);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		go(a, s, 0, 0);
		if(s == 0) cnt -= 1;
		System.out.println(cnt);
	}

}
