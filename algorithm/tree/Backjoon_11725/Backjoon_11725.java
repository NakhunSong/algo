import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> a[];
	static int[] parent;
	static boolean[] check;
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		check[1] = true;
		q.add(1);
		while(!q.isEmpty()) {
			int x = q.remove();
			for(int y : a[x]) { // 연결된 간선
				if(check[y] == false) {
					check[y] = true;
					parent[y] = x;
					q.add(y);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<n-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		check = new boolean[n+1];
		parent = new int[n+1];
		
		bfs();
		for(int i=2; i<=n; i++) {
			System.out.println(parent[i]);
		}
	}

}
