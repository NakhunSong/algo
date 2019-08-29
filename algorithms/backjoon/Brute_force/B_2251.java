import java.util.*;

public class Main {
	public static int[] from = {0,1,2,2,1,0};
	public static int[] to = {1,2,0,1,0,2};
	public static class Pair {
		int a;
		int b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] limit = new int[3];
		for(int i=0; i<3; i++) {
			limit[i] = sc.nextInt();
		}
		int sum = limit[2];
		boolean[][] check = new boolean[201][201];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0));
		List<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()) {
			int[] now = new int[3];
			Pair p = q.remove();
			now[0] = p.a;
			now[1] = p.b;
			now[2] = sum-(now[0]+now[1]);
			for(int k=0; k<6; k++) {
				int[] next = {now[0], now[1], now[2]};
				next[to[k]] = next[to[k]]+next[from[k]];
				next[from[k]] = 0;
				if(next[to[k]]>=limit[to[k]]) {
					next[from[k]] = next[to[k]] - limit[to[k]];
					next[to[k]] = limit[to[k]];
				}
				if(!check[next[0]][next[1]]) {
					check[next[0]][next[1]] = true;
					q.add(new Pair(next[0], next[1]));
					if(next[0] == 0) {
						ans.add(next[2]);
					}
				}
			}
		}
		Collections.sort(ans);
		for(int a : ans) {
			System.out.print(a + " ");
		}
	}

}
