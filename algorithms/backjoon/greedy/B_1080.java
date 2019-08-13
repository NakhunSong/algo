package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1080 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] a = new int[N][M];
		for(int i=0; i<N; i++) {
			String width = br.readLine();
			for(int j=0; j<M; j++) {
				a[i][j] = width.charAt(j)-'0';
			}
		}
		int[][] b = new int[N][M];
		for(int i=0; i<N; i++) {
			String width = br.readLine();
			for(int j=0; j<M; j++) {
				b[i][j] = width.charAt(j)-'0';
			}
		}
		int cnt = 0;
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<M-2; j++) {
				if(a[i][j] != b[i][j]) {
					for(int x=i; x<=i+2; x++) {
						for(int y=j; y<=j+2; y++) {
							a[x][y] = 1-a[x][y];
						}
					}
					cnt += 1;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(a[i][j] != b[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(cnt);
		
	}

}
