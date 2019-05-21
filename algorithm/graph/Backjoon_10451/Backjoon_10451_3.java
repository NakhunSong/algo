import java.util.Scanner;

public class Main {
	static int[] a;
	static boolean[] c;
	public static void dfs(int x) {
		while(c[x] == false) { // 순열 사이클과 같이 어떤 함수가 항상 다른 함수 하나만을 호출해야 하는 경우는 해당 함수를 비재귀 형태로 바꿀 수 있음.
			c[x] = true;
			x = a[x];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			a = new int[n+1]; 
			for(int i=1; i<=n; i++) {
				a[i] = sc.nextInt(); // 순열 사이클은 한 정점이 다음 정점 한개만을 갖는다.
			}
			c = new boolean[n+1];
			int ans = 0;
			for(int i=1; i<=n; i++) {
				if(c[i] == false) {
					dfs(i);
					ans+=1;
				}
			}
			System.out.println(ans);
		}
	}

}
