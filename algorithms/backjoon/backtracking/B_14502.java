import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	static int m;
	static int[][] a, map;
	static int max = 0;
	public static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static int checkAfterBirus() {
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = a[i][j];
			}
		}
		Queue<Pair> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 2) q.add(new Pair(i ,j));
			}
		}
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny] == 0) {
						q.add(new Pair(nx, ny));
						map[nx][ny] = 2;
					}
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void getWall(int index, int cnt) {
		if(cnt == 3) {
			int now = checkAfterBirus();
			max = Math.max(max, now);
			return;
		}
		for(int i=index; i<n*m; i++) {
			int row = i/m;
			int col = i%m;
			if(a[row][col] == 0) {
				a[row][col] = 1;
				getWall(index+1, cnt+1);
				a[row][col] = 0;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] first = br.readLine().split(" ");
		n = Integer.valueOf(first[0]);
		m = Integer.valueOf(first[1]);
		a = new int[n][m];
		for(int i=0; i<n; i++) {
			String[] second = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				a[i][j] = Integer.valueOf(second[j]);
			}
		}
		for(int i=0; i<n * m; i++) {
			int row = i/m;
			int col = i%m;
			if(a[row][col] == 0) {
				a[row][col] = 1;
				getWall(i, 1);
				a[row][col] = 0;
			}
		}
		System.out.println(max);
	}

}
