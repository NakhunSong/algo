import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f = sc.nextInt();
		
		int check = 0;
		
		n -= n%100;
		while(true) {
			if((float)(n%f) == 0) {
				break;
			}
			n++;
			check++;
		}
		if(check < 10) {
			String num = "0" + Integer.toString(check);
			System.out.println(num);
		} else {
			System.out.println(check);
		}
	}

}
