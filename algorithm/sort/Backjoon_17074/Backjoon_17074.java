import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] a = new int[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		int ans = 0;
		int check = 0;
		int idx = 0;
		for(int i=1; i<n; i++) {
			if(a[i] > a[i+1]) {
				check++;
				idx = i;
			}
		}
		
		if(check >= 2) {
			ans = 0;
		} else if(check==1){
			int fail = 0;
			for(int i=idx+1; i<=n; i++) {
				if(a[idx-1] > a[i]) {
					fail+=1;
					break;
				}
			}
			for(int i=idx+2; i<=n; i++) {
				if(a[idx] > a[i]) {
					fail+=1;
					break;
				}
			}
			if(fail == 0) {
				ans = 2;
			} else if(fail == 1) {
				ans = 1;
			} else {
				ans = 0;
			}
		} else {
			ans = n;
		}
		
		System.out.println(ans);
	}

}
