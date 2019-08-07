import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		sc.nextLine();
		String second = sc.nextLine();
		int sum = 0;
		int o = first*(second.charAt(2)-'0');
		System.out.println(o);
		sum += o;
		int t = first*(second.charAt(1)-'0');
		System.out.println(t);
		sum += t*10;
		int h = first*(second.charAt(0)-'0');
		System.out.println(h);
		sum += h*100;
		System.out.println(sum);
	}

}
