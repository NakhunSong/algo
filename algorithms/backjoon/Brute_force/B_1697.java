import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int max = 500000;
		boolean[] check = new boolean[max];
		int[] d = new int[max];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		check[n] = true;
		d[n] = 0;
		while(!q.isEmpty()) {
			int x = q.remove();
			if(x-1 >= 0 && check[x-1] == false) {
				q.add(x-1);
				d[x-1] = d[x] + 1;
				check[x-1] = true;
			}
			if(x+1 < max && check[x+1] == false) {
				q.add(x+1);
				d[x+1] = d[x] + 1;
				check[x+1] = true;
			}
			if(2*x < max && check[2*x] == false) {
				q.add(2*x);
				d[2*x] = d[x] + 1;
				check[2*x] = true;
			}
		}
		System.out.println(d[k]);
	}

}
