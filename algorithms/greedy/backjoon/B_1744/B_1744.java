import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int positiveIdx = 0;
		for(int i=0; i<n; i+=2) {
			if(a[i] > 0) {
				positiveIdx = i; // 양수가 되는 시점의 인덱스
			}
		}
		int ans = 0;
		for(int i=0; i<=positiveIdx-1; i++) { // 양수 전까지
			if(i+1<=positiveIdx-1) {
				ans += (a[i] * a[i+1]);				
			} else {
				ans += a[i];
			}
		}
		
		for(int i=n-1; i>=positiveIdx; i--) {
			if(i-1 >= positiveIdx && a[i-1] > 1) {
				ans += (a[i] * a[i-1]);
			} else {
				ans += a[i];
			}
		}
		System.out.println(ans);
	}
}
