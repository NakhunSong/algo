import java.util.*;
import java.io.*;

public class Main {
	public static long calc(long[] a, Stack<Integer> stack, long area, int i) {
		int lastIndex = stack.pop();
		long width = i;
		if(!stack.isEmpty()) {
			long leftIndex = stack.peek();
			width = i-leftIndex-1;
		}
		area = Math.max(area, width*a[lastIndex]);
		return area;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] s = br.readLine().split(" ");
			int n = Integer.valueOf(s[0]);
			if(n == 0) {
				break;
			}
			long[] a = new long[n];
			for(int i=0; i<n; i++) {
				a[i] = Long.valueOf(s[i+1]);
			}
			Stack<Integer> stack = new Stack<>();
			long area = 0;
			for(int i=0; i<n; i++) {
				while(!stack.isEmpty() && a[stack.peek()] > a[i]) {
					area = calc(a, stack, area, i);
				}
				stack.add(i);
			}
			Iterator<Integer> it = stack.iterator();
			while(it.hasNext()) {
				area = calc(a, stack, area, n);
			}
			System.out.println(area);
		}
	}

}

