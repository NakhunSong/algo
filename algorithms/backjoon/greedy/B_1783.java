import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int ans = 0;
		if(N == 1) {
			System.out.println(1);
			return;
		}
		if(N == 2) {
			ans = Math.min(4, (M+1)/2);
			System.out.println(ans);
			return;
		}
		if(M < 7) {
			ans = Math.min(4, M);
			System.out.println(ans);
			return;
		}
		System.out.println(M-2);
	}

}
