import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long b = sc.nextLong();
		String ans = "";
		while(n!=0) {
			long a = n%b;
			if(a>9) {
				a += 55;
				ans = Character.toString((char)a) + ans;
			} else {
				ans = a + ans;
			}
			n /= b;
		}
		System.out.println(ans);
	}

}
