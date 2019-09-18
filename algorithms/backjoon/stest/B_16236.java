import java.util.*;
import java.io.*;
public class Main {
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n;
	static int[][] a;
	static int size = 2;
	static int eat = 0;
	static int move = 0;
	static int ans = 0;
	public static void sizeUp() {
		if(eat == size) {
			size++;
			eat = 0;
		}
	}
	public static int find(int x, int y) {
		int nowx = x;
		int nowy = y;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		boolean[][] check = new boolean[n][n];
		int[][] d = new int[n][n];
		check[x][y] = true;
		d[x][y] = 0;
		int min = 2000;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(!check[nx][ny] && a[nx][ny] <= size) {
						check[nx][ny] = true;
						d[nx][ny] = d[x][y] + 1;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
		int nextx = nowx;
		int nexty = nowy;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(check[i][j] == true && a[i][j] < size && a[i][j] != 0) {
					if(d[i][j] < min) {
						min = d[i][j];
						move = d[i][j];
						nextx = i;
						nexty = j;
					}
				}
			}
		}
		if(!(nextx == nowx && nexty == nowy)) { // 먹으면
			a[nextx][nexty] = 0;
			a[nowx][nowy] = 0;
			eat++;
			sizeUp();
		}
		return (nextx*n + nexty);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		a = new int[n][n];
		int x = 0;
		int y = 0;
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.valueOf(line[j]);
				if(a[i][j] == 9) {
					x = i;
					y = j;
				}
			}
		}
		while(true) {
			int next = find(x, y);
			if(next == (x*n+y)) {
				break;
			}
			x = next/n;
			y = next%n;
			ans += move;
			move = 0;
		}
		System.out.println(ans);
		
	}
}
