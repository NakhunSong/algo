import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			if(i==N) {
				for(int j=1; j<=(N+i-1); j++) {
					System.out.print("*");
				}
			} else if(i<N) {
				for(int j=1; j<N+i; j++) {
					if(j>N-i) {
						if(j==(N-i+1) || j==(N+i-1)) {
							System.out.print("*");
						} else {						
							System.out.print(" ");
						}
					} else
						System.out.print(" ");
				}
				System.out.println("");
			}
		}
		
	}

}
