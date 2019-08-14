import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[][] a;
	public static StringBuilder sb = new StringBuilder();
	public static boolean check(int size, int x, int y) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(a[x][y] != a[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void compass(int size, int x, int y) {
		if(check(size, x, y)) {
			sb.append(a[x][y]);
			return;
		}
		sb.append("(");
		size = size/2;
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				compass(size, x+i*size, y+j*size);
			}
		}
		sb.append(")");
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		a = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<N; j++) {
				a[i][j] = Integer.valueOf(s[j]);
			}
		}
		compass(N, 0, 0);
		System.out.println(sb);
	}

}
