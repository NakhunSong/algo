import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			boolean[] check = new boolean[10000];
			String[] d = new String[10000];
			
			Queue<Integer> q = new LinkedList<>();
			q.add(a);
			check[a] = true;
			d[a] = "";
			while(!q.isEmpty()) {
				int now = q.remove();

				int D = (now*2)%10000;
				if(check[D] == false) {
					q.add(D);
					d[D] = d[now] + "D"; 
					check[D] = true;
				}

				int S = now-1;
				if(S == -1) S = 9999;
				if(check[S] == false) {
					q.add(S);
					d[S] = d[now] + "S";
					check[S] = true;
				}
				
				int L = (now%1000)*10 + now/1000;
				if(check[L] == false) {
					check[L] = true;
					d[L] = d[now] + "L";
					q.add(L);
				}

				int R = (now/10) + (now%10)*1000;
				if(check[R] == false) {
					check[R] = true;
					d[R] = d[now] + "R";
					q.add(R);
				}

			}
			System.out.println(d[b]);
		}
	}

}
