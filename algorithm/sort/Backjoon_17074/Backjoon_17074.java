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
		int max = 0;
		int idx = 0;
		for(int i=1; i<n; i++) {
			if(a[i] > a[i+1]) {
				check++;
				max = a[i];
				idx = i;
			}
		}
		
		if(check >= 2) {
			ans = 0;
		} else if(check==1){
			int less = 0;
			int lessCnt = 0;
			for(int i=idx+1; i<=n; i++) {
				if(a[i] < max) {
					lessCnt++;
					less = a[i];
				}
			}
			if(lessCnt == 1) {
				if(a[idx-1] <= less) {
					ans = 2;
				} else {
					ans = 1;					
				}
			} else { // lessCnt 가 2개 이상
				
				ans = 0;
			}
		} else {
			ans = n;
		}
		
		System.out.println(ans);
	}

}
