import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int a = A;
		int b = B;
		int gcd = 0;
		while(true) {
			int r = a%b;
			if(r == 0) {
				gcd = b;
				break;
			}
			a = b;
			b = r;
		}
		
		int lcm = 0;
		lcm = A/gcd * B/gcd * gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}

}
