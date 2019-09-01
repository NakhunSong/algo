import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};
	public static int r;
	public static int c;
	public static String[][] a;
	public static Set<String> set = new HashSet<>();
	public static int go(int row, int col, int cnt) {
		int x = row;
		int y = col;
		int max = cnt;
		for(int k=0; k<4; k++) {
			set.add(a[x][y]);
			int nx = x+dx[k];
			int ny = y+dy[k];
			if(nx>=0 && nx<r && ny>=0 && ny<c) {
				if(!set.contains(a[nx][ny])) {
					max = Math.max(max, go(nx, ny, cnt+1));
				}				
			}
			set.remove(a[x][y]);
		}
		return max;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] first = br.readLine().split(" ");
		r = Integer.valueOf(first[0]);
		c = Integer.valueOf(first[1]);
		a = new String[r][c];
		for(int i=0; i<r; i++) {
			String[] second = br.readLine().split("");
			for(int j=0; j<c; j++) {
				a[i][j] = second[j];
			}
		}
		int ans = go(0, 0, 1);
		System.out.println(ans);
	}

}
