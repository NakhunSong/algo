import java.util.*;

public class Main {
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	
	public static void dfs(boolean[][] check, int[][] a, int x, int y) {
		if(check[y][x]) return;
		check[y][x] = true;
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx>=0 && nx<a[0].length && ny>=0 && ny<a.length) {
				if(a[ny][nx] == 1 && !check[ny][nx]) {
					dfs(check, a, nx, ny);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] a = new int[n][m];
			for(int i=0; i<k; i++) {
				int x = sc.nextInt(); // 가로
				int y = sc.nextInt(); // 세로
				a[y][x] = 1;
			}
			boolean[][] check = new boolean[n][m];
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(a[i][j] == 1 && !check[i][j]) {
						dfs(check, a, j, i);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
