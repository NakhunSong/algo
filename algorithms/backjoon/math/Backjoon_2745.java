import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] ss = s.split(" ");
		
		String n = ss[0];
		long b = Long.parseLong(ss[1]);
		
		long ans = 0;
		for(int i=0; i<n.length(); i++) {
			char c = n.charAt(n.length()-1-i);
			long a = 0;
			if(c>='0' && c<='9') {
				a = c - '0';
			} else {
				a = c - 'A' + 10;
			}
			int cnt = 1;
			for(int j=0; j<i; j++) {
				cnt *= b;
			}
			ans += a*cnt;
		}
		System.out.println(ans);
	}

}
