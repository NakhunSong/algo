import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=1; i<=2*N-1; i++) {
			if(i<=N) {
				for(int j=1; j<=N+i-1; j++) {
					if(j>N-i) 
						System.out.print("*");
					else
						System.out.print(" ");
				}
				System.out.println("");				
			}  else if(i>N) {
				for(int j=1; j<=N+(2*N-i)-1; j++) {
					if(j>i-N) {
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