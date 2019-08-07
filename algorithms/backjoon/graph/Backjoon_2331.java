import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] c = new int[1000000];
	static int p;
	
	public static int pow(int x) {
		int num = 1;
		for(int i=0; i<p; i++) {
			num = num * x;
		}
		return num;
	}
	public static int next(int x) {
		int sum = 0;
		while(x > 0) {
			sum += pow(x%10);
			x /= 10;
		}
		return sum;
	}
	public static int dfs(int x, int cnt) {
		if(c[x] != 0) {
			return c[x] - 1;
		}
		c[x] = cnt;
		int next = next(x);
		return dfs(next, cnt+1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		int ans = dfs(a, 1);
		System.out.println(ans);
	}
}
