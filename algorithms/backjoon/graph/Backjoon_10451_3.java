import java.util.Scanner;

public class Main {
	static int[] a;
	static boolean[] c;
	public static void dfs(int x) {
		while(c[x] == false) { // ���� ����Ŭ�� ���� � �Լ��� �׻� �ٸ� �Լ� �ϳ����� ȣ���ؾ� �ϴ� ���� �ش� �Լ��� ����� ���·� �ٲ� �� ����.
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
				a[i] = sc.nextInt(); // ���� ����Ŭ�� �� ������ ���� ���� �Ѱ����� ���´�.
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
