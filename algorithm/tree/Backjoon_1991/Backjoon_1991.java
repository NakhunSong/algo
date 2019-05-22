package backjoon.tree;

import java.util.Scanner;

public class Backjoon_1991 {
	static int[][] a;
	public static void preorder(int now) {
		if(now == -1) return;
		System.out.print((char)(now+'A'));
		preorder(a[now][0]);
		preorder(a[now][1]);
	}
	public static void inorder(int now) {
		if(now == -1) return;
		inorder(a[now][0]);
		System.out.print((char)(now+'A'));
		inorder(a[now][1]);
	}
	public static void postorder(int now) {
		if(now == -1) return;
		postorder(a[now][0]);
		postorder(a[now][1]);
		System.out.print((char)(now+'A'));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		a = new int[26][2];
		for(int i=0; i<n; i++) {
			String line = sc.nextLine();
			int x = line.charAt(0) - 'A';
			char y = line.charAt(2); // 왼쪽 자식 노드. 띄워쓰기 1칸씩 띄워야 함
			char z = line.charAt(4); // 오른쪽 자식 노드
			if(y == '.') {
				a[x][0] = -1;
			} else {
				a[x][0] = y - 'A';
			} 
			if(z == '.') {
				a[x][1] = -1;
			} else {
				a[x][1] = z - 'A';
			}
		}
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
		System.out.println();
	}

}
