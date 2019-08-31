import java.util.Scanner;

public class Main {
	public static boolean[][] a = new boolean[15][15];
	public static int n;
	public static int cnt = 0;
	public static boolean check(int row, int col) {
		for(int i=0; i<n; i++) {
			if(row==i) continue;
			if(a[i][col] == true) {
				return false;
			}
		}
		int x = row-1;
		int y = col-1;
		while(x>=0 && y>=0) {
			if(a[x][y] == true) {
				return false;
			}
			x -= 1;
			y -= 1;
		}
		x = row-1;
		y = col+1;
		while(x>=0 && y<n) {
			if(a[x][y] == true) {
				return false;
			}
			x -= 1;
			y += 1;
		}
		return true;
	}
	public static void go(int row) {
		if(row == n) {
			cnt+=1;
		}
		for(int col=0; col<n; col++) {
			a[row][col] = true;
			if(check(row, col)) {
				go(row+1);
			}
			a[row][col] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		go(0);
		System.out.println(cnt);
	}

}
