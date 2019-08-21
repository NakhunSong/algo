import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static long[] f;
	public static boolean[] c;

	public static long check(int[] b) {
		int n = b.length;
		long sum = 0;
		int i = 0;
		while(i < n) {
			for(int j=1; j<b[i]; j++) {
				if(c[j] == false) {
					sum += f[n-i-1];				
				}
			}
			c[b[i]] = true;
			i++;				
		}
		return sum;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		f = new long[n+1];
		c = new boolean[n+1];
		Arrays.fill(f, 1);
		for(int i=1; i<=n; i++) {
			f[i] = f[i-1] * i;
		}
		if(m == 1) {
			long k = sc.nextLong();
			int[] a = new int[n];
			for(int i=0; i<n; i++) {
				for(int j=1; j<=n; j++) {
					if(c[j] == true) continue;
					if(f[n-i-1] < k) {
						k -= f[n-i-1];
					} else {
						a[i] = j;
						c[j] = true;
						break;
					}
				}
			}
			for(int i=0; i<n; i++) {
				System.out.print(a[i] + " ");
			}
		} else if(m == 2){
			int[] b = new int[n];
			for(int i=0; i<n; i++) {
				b[i] = sc.nextInt();
			}
			long result = check(b);
			System.out.println(result+1);
		}
		
	}

}
