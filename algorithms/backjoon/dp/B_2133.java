import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n+1];
		
		d[0] = 1;
		d[1] = 0;
		for(int i=2; i<=n; i+=2) {
			d[i] = d[i-2]*3;
			for(int j=4; j<=i; j+=2) {
				d[i] += d[i-j]*2;
			}
		}
		System.out.println(d[n]);
	}

}
