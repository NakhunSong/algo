import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int[] a = new int[n];
		int[] b = new int[m];
		int[] c = new int[n+m];
		
		s = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(s[i]);
			c[i] = a[i];
		}
		s = br.readLine().split(" ");
		for(int i=0; i<m; i++) {
			b[i] = Integer.parseInt(s[i]);
			c[n+i] = b[i];
		}
		int[] tmp = new int[n+m];
		for(int i=0; i<n+m; i++) {
			tmp[i] = c[i];
		}
		int part1 = 0;
		int part2 = n-1+1;
		int index = 0;
		while(part1 <= n-1 && part2 <= n+m-1) {
			if(tmp[part1] <= tmp[part2]) {
				c[index] = tmp[part1];
				part1++;
			} else {
				c[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for(int i=0; i<=n-1 - part1; i++) {
			c[index+i] = tmp[part1+i];
		}
		for(int i=0; i<n+m; i++) {
			bw.write(Integer.toString(c[i]) + " ");
		}
		bw.close();
		br.close();
	}

}
