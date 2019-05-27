import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[n+1];
		int mod = 10007;
		d[0] = 1;
		d[1] = 1;
		for(int i=2; i<=n; i++) {
			d[i] = (d[i-1] + d[i-2] + d[i-2]);
			d[i] %= mod;
		}
		bw.write(Integer.toString(d[n]));
		bw.close();
		br.close();
	}

}
