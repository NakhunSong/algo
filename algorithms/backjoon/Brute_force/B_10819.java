import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int calc(int[] a) {
		int sum = 0;
		for(int i=1; i<a.length; i++) {
			sum += Math.abs(a[i-1] - a[i]);
		}
		return sum;
		
	}
	public static boolean next_permutation(int[] a) {
		int i = a.length-1;
		while(i > 0 && a[i-1] >= a[i]) {
			i -= 1;
		}
		if(i <= 0) return false;
		
		int j = a.length-1;
		while(a[i-1] >= a[j]) {
			j -= 1;
		}
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length-1;
		while(i<j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i+=1;
			j-=1;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] a= new int[n];
		String[] s = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.valueOf(s[i]);
		}
		Arrays.sort(a);
		int max = 0;
		do {
			max = Math.max(max, calc(a));
		} while(next_permutation(a));
		System.out.println(max);
	}

}
