import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pair {
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n;
	static int m;
	static boolean[][] visit;
	static int[][] c;
	static int[][] a;
	
	public static void bfs(int x, int y, int cnt) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));
		visit[x][y] = true;
		c[x][y] = 1;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];	
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(a[nx][ny] == 1 && visit[nx][ny] == false) {
						q.add(new Pair(nx, ny));
						visit[nx][ny] = true;
						c[nx][ny] = c[x][y] + 1;
					}
				}
			}	
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		a = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String s = sc.nextLine(); 
			for(int j=0; j<m; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
			
		}
		visit = new boolean[n][m];
		c = new int[n][m];
		bfs(0, 0, 1);
		
		System.out.println(c[n-1][m-1]);
	}

}
