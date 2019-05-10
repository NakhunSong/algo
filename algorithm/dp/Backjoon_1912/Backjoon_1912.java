import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		int[] d = new int[n+1];
		d[1] = a[1];
		for(int i=2; i<=n; i++) {
			if(a[i] > d[i-1] + a[i]) {
				d[i] = a[i];
			} else {
				d[i] = d[i-1] + a[i];
			}
		}
		int ans = d[1];
		for(int i=2; i<=n; i++) {
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}

}
