import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 1000000;
		String s = br.readLine();
		int n = s.length();
		s = " " + s;
		int[] d = new int[n+1];
		d[0] = 1;
		int ans = 0;
		for(int i=1; i<=n; i++) {
			int x = s.charAt(i) -'0';
			if(x>=1 && x<=9) {
				d[i] += d[i-1];
				d[i] %= mod;
			} 
			if(i==1) continue;
			if(s.charAt(i-1) == '0') continue;
			x = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
			if(x >= 10 && x<=26) {
				d[i] += d[i-2];
				d[i] %= mod;
			}
		}
		System.out.println(d[n]);
	}

}
