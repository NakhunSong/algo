import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] el = br.readLine().split(" ");
		int N = Integer.valueOf(el[0]);
		int M = Integer.valueOf(el[1]);
		int K = Integer.valueOf(el[2]);
		
		int contest = 0;
		while(true) {
			if(N+M>=K+3 && M>=1 && N>=2) {
				N-=2;
				M-=1;
				contest++;
			} else {
				break;
			}
		}
		System.out.println(contest);
	}

}
