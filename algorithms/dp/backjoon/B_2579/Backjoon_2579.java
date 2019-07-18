import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		a[0] = 0;
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		int[] d = new int[n+1];
		d[0] = a[0];
		d[1] = a[0] + a[1];
		d[2] = a[1] + a[2];
		for(int i=3; i<=n; i++) {
			d[i] = d[i-2] + a[i];
			if(d[i-3] + a[i-1] + a[i] > d[i]) {
				d[i] = d[i-3] + a[i-1] + a[i];
			}
		}
		System.out.println(d[n]);
	}

}
