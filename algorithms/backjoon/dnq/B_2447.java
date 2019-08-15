// Answer is correct but it occurs timeout.

import java.util.Scanner;

public class Main {
	public static char[][] a;
	public static StringBuilder sb = new StringBuilder();
	public static void solution(int size, int x, int y, boolean isStar) {
		if(!isStar) {
			for(int i=x; i<x+size; i++) {
				for(int j=y; j<y+size; j++) {
					a[x][y] = ' ';
				}
			}
			return;
		} else {
			if(size == 1) {
				a[x][y] = '*';
				return;
			}
			size = size/3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i==1 && j==1) {
						isStar = false;
					} else {
						isStar = true;
					}
					solution(size, x+i*size, y+j*size, isStar);
				}
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new char[n][n];
		solution(n, 0, 0, true);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(a[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
