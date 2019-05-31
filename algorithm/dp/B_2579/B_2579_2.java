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
		int[][] d = new int[n+1][3];
		d[1][1] = a[1];
		d[1][2] = 0; // 조건에 만족하는 수 없음
		for(int i=2; i<=n; i++) {
			d[i][2] = d[i-1][1] + a[i];
			d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + a[i];
		}
		int ans = Math.max(d[n][1], d[n][2]);
		System.out.println(ans);
	}

}
