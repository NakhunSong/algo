import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[] cnt = new int[3];
	public static int[][] a;
	
	public static void counter(int size, int x, int y) {
		if(check(size, x, y)) {
			cnt[a[x][y]+1] += 1;
			return;
		}
		size = size/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				counter(size, x+i*size, y+j*size);
			}
		}
	}
	public static boolean check(int size, int x, int y) {
		int num = a[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(num != a[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				a[i][j] = Integer.parseInt(s[j]);
			}
		}
		int i=0;
		int j=0;
		counter(N, i, j);
		StringBuilder sb = new StringBuilder();
		for(int k=0; k<3; k++) {
			sb.append(cnt[k]+"\n");
		}
		System.out.println(sb);
	}

}
