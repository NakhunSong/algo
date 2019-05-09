import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] a = new int[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		int[] d = new int[n+1];
		
		int ans = a[1];
		for(int i=1; i<=n; i++) {
			d[i] = a[i];
			for(int j=1; j<i; j++) {
				if(a[j] < a[i] && d[i] < d[j] + a[i]) {
					d[i] = d[j] + a[i];
				}
			}
			ans = Math.max(ans, d[i]);
		}
		
		System.out.println(ans);
	}

}
