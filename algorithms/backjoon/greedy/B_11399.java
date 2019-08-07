import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] P = new int[N];
		for(int i=0; i<N; i++) {
			P[i] = Integer.valueOf(s[i]);
		}
		Arrays.sort(P);
		int now = 0;
		int ans = 0;
		for(int i=0; i<N; i++) {
			now += P[i];
			ans += now;
		}
		System.out.println(ans);
	}

}
