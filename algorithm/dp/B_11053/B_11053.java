import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		int[] d = new int[n+1];
		
		String[] s = br.readLine().split(" ");
		for(int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(s[i-1]);
		}
		for(int i=1; i<=n; i++) {
			d[i] = 1;
			for(int j=1; j<i; j++) {
				if(a[j] < a[i] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
			}
		}
		int ans = d[1];
		for(int i=2; i<=n; i++) {
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}

}
