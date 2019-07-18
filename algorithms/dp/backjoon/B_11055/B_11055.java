import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		int[] d = new int[n+1]; // 증가 부분 수열 최대 합
		String[] s = br.readLine().split(" ");
		for(int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(s[i-1]);
		}
		d[1] = a[1];
		for(int i=2; i<=n; i++) {
			d[i] = a[i];
			for(int j=1; j<i; j++) {
				if(a[j]<a[i] && d[i] < d[j]+a[i]) {
					d[i] = d[j] + a[i]; // d[i] = 1 101 3 53 113 6 ... 이런 식이어야 함.
				}
			}
//			if(d[i] < d[i-1]) {  // 이 문장은 d[i] = 1 101 101 101 113 113 113 ... 
//				d[i] = d[i-1];
//			}
		}
		int ans = 0;
		for(int i=1; i<=n; i++) {
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}

}
