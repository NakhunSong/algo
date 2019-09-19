import java.util.*;
import java.io.*;

public class Main {
	public static class Pair {
		int idx;
		long h;
		public Pair(int idx, long h) {
			this.idx = idx;
			this.h = h;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		long[] a = new long[n];
		String[] line = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			a[i] = Long.valueOf(line[i]);
		}
		Stack<Pair> stack = new Stack<>();
		stack.add(new Pair(0, a[0]));
		StringBuilder sb = new StringBuilder();
		sb.append("0 ");
		for(int i=1; i<n; i++) {
			while(!stack.isEmpty()) {
				if(stack.peek().h > a[i]) {
					sb.append(stack.peek().idx+1+ " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) sb.append(0 + " ");
			stack.add(new Pair(i, a[i]));
		}
		System.out.println(sb);
	}
}
