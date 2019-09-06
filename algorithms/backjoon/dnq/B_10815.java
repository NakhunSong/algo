import java.util.*;
import java.io.*;

public class Main {
	public static boolean check(int[] a, int target) {
		int left = 0;
		int right = a.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(a[mid] == target) {
				return true;
			} else if(a[mid] > target) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		String[] first = br.readLine().split(" ");
		int m = Integer.valueOf(br.readLine());
		String[] second = br.readLine().split(" ");
		int[] a = new int[n];
		int[] b = new int[m];
		for(int i=0; i<n; i++) {
			a[i] = Integer.valueOf(first[i]);
		}
		for(int i=0; i<m; i++) {
			b[i] = Integer.valueOf(second[i]);
		}
		Arrays.sort(a);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			if(check(a, b[i])) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);
		
	}

}
