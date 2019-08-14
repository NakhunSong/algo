import java.util.Scanner;

public class Main {
	public static int cnt = 0;
	public static StringBuilder sb = new StringBuilder();
	public static void solve(int n, int x, int y) {
		if(n == 0) {
			return;
		}
		solve(n-1, x, 6-x-y);
		sb.append(x + " " + y + "\n");
		cnt+=1;
		solve(n-1, 6-x-y, y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		solve(N, 1, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}

}
