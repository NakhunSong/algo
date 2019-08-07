import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		long twoCnt = 0;
		long fiveCnt = 0;
		for(long i=5; i<=n; i*=5) {
			fiveCnt += n/i;
		}
		for(long i=2; i<=n; i*=2) {
			twoCnt += n/i;
		}
		for(long i=5; i<=m; i*=5) {
			fiveCnt -= m/i;
		}
		for(long i=2; i<=m; i*=2) {
			twoCnt -= m/i;
		}
		for(long i=5; i<=n-m; i*=5) {
			fiveCnt -= (n-m)/i;
		}
		for(long i=2; i<=n-m; i*=2) {
			twoCnt -= (n-m)/i;
		}
		System.out.println(Math.min(twoCnt, fiveCnt));
	}

}
