import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		long mod = 1000000000;
		long[] d = new long[n+1];
		d[0] = 1;
		for(int i=1; i<=k; i++) {
			for(int j=n; j>=0; j--) {
				for(int l=1; l<=j; l++) {
					d[j] += d[j-l];
					d[j] %= mod;
				}
				System.out.println(d[j]);
			}
		}
		System.out.println(d[n]);
	}

}
