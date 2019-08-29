import java.util.*;

public class Main {
	public static int go(int sum, int target) {
		if(sum > target) return 0;
		if(sum == target) return 1;
		int cnt = 0;
		for(int i=1; i<=3; i++) {
			cnt += go(sum+i, target);
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			System.out.println(go(0, n));
		}
	}

}
