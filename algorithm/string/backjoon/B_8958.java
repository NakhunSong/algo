import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			String s = br.readLine();
			int num = 0;
			int ans = 0;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == 'O') {
					num += 1;
					ans += num;
				} else {
					num = 0;
				}
			}
			System.out.println(ans);
		}
	}

}
