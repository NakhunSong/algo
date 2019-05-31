import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		int[] d = new int[n+1];
		d[1] = a[1];
		d[2] = a[1] + a[2];
		d[3] = Math.max(a[1], a[2]) + a[3];
		for(int i=3; i<=n; i++) {
			d[i] = d[i-2] + a[i];
			d[i] = Math.max(d[i], d[i-3]+a[i-1]+a[i]);
		}
		System.out.println(d[n]);
	}

}
