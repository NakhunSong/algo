import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int change(int now, int index, int num) {
		if(index == 0 && num == 0) return -1;
		StringBuilder sNum = new StringBuilder(Integer.toString(now));
		sNum.setCharAt(index, (char)(num+'0'));
		return Integer.parseInt(sNum.toString());
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[10001];
		for(int i=2; i<=10000; i++) {
			if(prime[i] == false) {
				for(int j=i*i; j<=10000; j+=i) {
					prime[j] = true;
				}				
			}
		}
		for(int i=0; i<=10000; i++) {
			prime[i] = !prime[i];
		}
		
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int first = sc.nextInt();
			int target = sc.nextInt();
			boolean[] check = new boolean[10001];
			int[] d = new int[10001];
			check[first] = true;
			d[first] = 0;
			Queue<Integer> q = new LinkedList<>();
			q.add(first);
			
			while(!q.isEmpty()) {
				int now = q.remove();
				for(int j=0; j<4; j++) {
					for(int k=0; k<=9; k++) {
						int next = change(now, j, k);
						if(next != -1) {
							if(check[next] == false && prime[next] == true) {
								check[next] = true;
								d[next] = d[now] + 1;
								q.add(next);
							}							
						}
					}
				}
			}
			System.out.println(d[target]);
		}
	}

}
