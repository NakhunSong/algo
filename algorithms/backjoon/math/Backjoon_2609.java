import java.util.Scanner;

public class Main {
	public static int gcd(int a, int b) {
		if(b==0) {
			return a;
		}
		return gcd(b, a%b);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int gcd = gcd(A, B);
		
		int lcm = 0;
		lcm = A/gcd * B/gcd * gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}

}
