import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().trim();
		int n = s.length();
		s = " " + s;
		int[] d = new int[n+1];
		int mod = 1000000;
		d[0] = 1;
		for(int i=1; i<=n; i++) {
			int c = s.charAt(i) - '0';
			if(c>=1 && c<=9) {
				d[i] = (d[i] + d[i-1]) % mod;
			}
			if(i==1) continue;
			if(s.charAt(i-1) == '0') continue;
			c = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
			if(c>=10 && c<=26) {
				d[i] = (d[i] + d[i-2]) % mod;
			}
		}
		
		System.out.println(d[n]);
	}

}
