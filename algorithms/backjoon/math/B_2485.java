import java.util.*;

public class Main {
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) { 
			a[i] = sc.nextInt();
		}
		int[] inter = new int[n];
		for(int i=0; i<n-1; i++) {
			inter[i] = a[i+1]-a[i];
		}
		for(int i=0; i<n-1; i++) {
			inter[i+1] = gcd(inter[i+1], inter[i]);
		}
		int min = inter[n-1];
		int ans = (a[n-1]-a[0])/min - (n-1);
		System.out.println(ans);
	}

}
