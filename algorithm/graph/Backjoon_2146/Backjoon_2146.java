import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Pair {
		public int x;
		public int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static final int[] dx = {0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0};
	public static int n;
	public static int[][] a;
	public static int[][] group;
	public static int[][] dist;
	public static void bfs(int x, int y, int cnt) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));
		group[x][y] = cnt;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(a[nx][ny] == 1 && group[nx][ny] == 0) {
						group[nx][ny] = cnt;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		group = new int[n][n];
		dist = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == 1 && group[i][j] == 0) {
					bfs(i, j, ++cnt);
				}
			}
		}
		
		Queue<Pair> q2 = new LinkedList<Pair>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == 0) {
					dist[i][j] = -1;
				} else if(a[i][j] == 1){
					q2.add(new Pair(i, j));
					dist[i][j] = 0;
				}
			}
		}
		while(!q2.isEmpty()) {
			Pair p = q2.remove();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				 if (0<=nx && nx<n && 0<=ny && ny<n) {
					 if(dist[nx][ny] == -1) {
						 dist[nx][ny] = dist[x][y] + 1;
						 group[nx][ny] = group[x][y];
						 q2.add(new Pair(nx, ny));
					 }
				 }
			}
		}
		
		int ans = -1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<4; k++) {
					int x = i+dx[k];
					int y = j+dy[k];
					if (0 <= x && x < n && 0 <= y && y < n) {
						if(group[i][j] != group[x][y]) {
							if(ans == -1 || ans > dist[i][j] + dist[x][y]) {
								ans = dist[i][j] + dist[x][y];
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

}
