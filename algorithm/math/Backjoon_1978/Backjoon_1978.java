import java.util.Scanner;

public class Main {
	public static boolean prime(int a) {
		if(a<2) {
			return false;
		}
		for(int i=2; i*i<=a; i++) {
			if(a%i==0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			if(prime(a)) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
