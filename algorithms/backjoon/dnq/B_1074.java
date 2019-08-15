// Answer is correct but it occurs out of memory
 
import java.util.Scanner;

public class Main {
	public static long[][] a;
	public static int cnt = 0;
	public static void check(int x, int y) {
		for(int i=x; i<x+2; i++) {
			for(int j=y; j<y+2; j++) {
				a[i][j] = cnt++;
			}
		}
	}
	public static void go(int size, int x, int y) {
		if(size == 2) {
			check(x, y);
			return;
		}
		size = size/2;
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				go(size, x+i*size, y+j*size);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int size = (int)Math.pow(2, n);
		a = new long[size][size];
		go(size, 0, 0);
		System.out.println(a[r][c]);
	}

}
