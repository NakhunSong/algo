import java.util.*;

public class Main {
	public static class Pair {
		int h;
		int cnt;
		public Pair(int h, int cnt) {
			this.h = h;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		Stack<Pair> stack = new Stack<>();
		long cnt = 0;
		for(int i=0; i<n; i++) {
			Pair p = new Pair(a[i], 1);
			while(!stack.isEmpty()) {
				if(stack.peek().h <= a[i]) {
					cnt += (long)stack.peek().cnt;
					if(stack.peek().h == a[i]) {
						p.cnt += stack.peek().cnt;
					} 
					stack.pop();
				} else {
					break;
				}
			}
			if(!stack.isEmpty()) {
				cnt += 1L;
			}
			stack.add(p);
		}
		System.out.println(cnt);
		
	}

}
