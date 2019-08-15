import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[] a;
	public static long swap;
	public static void sort(int start, int end) {
		if(start == end) {
			return;
		}
		int mid = (start+end)/2;
		sort(start, mid);
		sort(mid+1, end);
		merge(start, end);
	}
	public static void merge(int start, int end) {
		int[] temp = new int[end-start+1];
		int mid = (start+end)/2;
		int x = start;
		int y = mid+1;
		int idx = 0;
		while(x<=mid && y<=end) {
			if(a[x]<=a[y]) {
				temp[idx++] = a[x++];
			}
			else {
				temp[idx++] = a[y++];
				swap = swap + (long)(mid-x+1);
			} 
		}
		while(x<=mid) temp[idx++] = a[x++];
		while(y<=end) temp[idx++] = a[y++];
		
		for(int i=start; i<=end; i++) {
			a[i] = temp[i-start];
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		a = new int[n];
		String[] s = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.valueOf(s[i]);
		}
		sort(0, n-1);
		System.out.println(swap);
	}

}
