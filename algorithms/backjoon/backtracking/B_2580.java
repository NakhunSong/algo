import java.io.*;
import java.util.*;

public class Main {
	public static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static int n = 9;
	public static int[][] a = new int[n][n];
	public static boolean[][] c = new boolean[n][n];
	public static List<Pair> list;
	public static boolean check(int row, int col) {
		// |
		for(int i=0; i<9; i++) {
			if(i == row) continue;
			if(a[i][col] == a[row][col]) {
				return false;
			}
		}
		// ㅡ
		for(int i=0; i<9; i++) {
			if(i == col) continue;
			if(a[row][i] == a[row][col]) {
				return false;
			}
		}
		// ㅁ
		int xStart = (row/3)*3;
		int yStart = (col/3)*3;
		int x = xStart;
		int y = yStart;
		while(!(x%3==2 && y%3==2)) {
			if(!(x == row && y == col)) {
				if(a[x][y] == a[row][col]) {
					return false;
				}
			}
			y+=1;
			if(y%3==0) {
				y = yStart;
				x+=1;
			}
		}
		return true;
	}
	public static void go(int index) {
		if(index == list.size()) {
			for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
		}
		Pair p = list.get(index);
		int x = p.x;
		int y = p.y;
		for(int i=1; i<=9; i++) {
			a[x][y] = i;
			if(check(x, y)) {
				go(index+1);
			}
			a[x][y] = 0;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.valueOf(s[j]);
				if(a[i][j] == 0) {
					list.add(new Pair(i, j));
				}
			}
		}
		go(0);
	}

}
