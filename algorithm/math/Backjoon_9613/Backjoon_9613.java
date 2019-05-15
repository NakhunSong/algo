import java.util.Scanner;

public class Main {
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] ans = new long[t];
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			int[] num = new int[n];
			for(int j=0; j<n; j++) {
				num[j] = sc.nextInt();
			}
			long sum = 0; 
			for(int j=0; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					int r = gcd(num[j], num[k]);
					sum += r;
				}
			}
			ans[i] = sum;
		}
		for(int i=0; i<t; i++) {
			System.out.println(ans[i]);
		}
		
	}

}
