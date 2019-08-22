import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static Set<Integer> set;
	public static int check(int now) {
		if(now == 0) {
			if(set.contains(now)) {
				return 0;
			} else {
				return 1;
			}
		}
		int cnt = 0;
		while(now > 0) {
			if(set.contains(now%10)) {
				return 0;
			}
			cnt++;
			now = now/10;
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		set = new HashSet<>();
		for(int i=0; i<m; i++) {
			a[i] = sc.nextInt();
			set.add(a[i]);
		}
		int min = Math.abs(100 - n);
		for(int i=0; i<=1000000; i++) {
			int now = i;
			if(check(now) >= 1) {
				int cnt = Math.abs(n-now)+check(now);
				min = Math.min(cnt, min);
			}
		}
		System.out.println(min);
	}

}
