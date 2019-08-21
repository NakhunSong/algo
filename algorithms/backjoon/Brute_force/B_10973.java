import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static boolean previous(int[] a) {
		int i = a.length-1;
		while(i > 0 && a[i] >= a[i-1]) {
			i -= 1;
		}
		if(i <= 0) {
			return false;
		}
		int j = a.length - 1;
		while(a[i-1] <= a[j]) {
			j -= 1;
		}
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length - 1;
		while(i<j) {
			int temp2 = a[i];
			a[i] = a[j];
			a[j] = temp2;
			i++;
			j--;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.valueOf(s[i]);
		}
		if(previous(a)) {
			for(int i=0; i<n; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println("-1");
		}
	}

}
