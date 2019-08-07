import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=1; i<=2*N-1; i++) {
			if(i<=N) {
				for(int j=1; j<=2*N; j++) {
					if(j<=i || j>2*N-i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println("");				
			} else {
				for(int j=1; j<=2*N; j++) {
					if(j<=2*N-i || j>i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println("");											
			}
		}
	}

}