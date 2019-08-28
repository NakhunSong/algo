// Correct but timeout
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int change(int now, String command) {
		String[] s = Integer.toString(now).split("");
		String num = "";
		if(command.equals("L")) {
			String temp = s[0];
			for(int i=1; i<s.length; i++) {
				s[i-1] = s[i];
				num+=s[i-1];
			}
			s[s.length-1] = temp;			
			num+=s[s.length-1];
		} else {
			String temp = s[s.length-1];
			for(int i=0; i<s.length-1; i++) {
				s[i+1] = s[i]; 
				num+=s[i+1];
			}
			s[0] = temp;
			num+=s[0];
		}
		
		return Integer.parseInt(num);
	}
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
				int L = change(now, "L");
				if(check[L] == false) {
					check[L] = true;
					d[L] = d[now] + "L";
					q.add(L);
				}
				int R = change(now, "R");
				if(check[R] == false) {
					check[R] = true;
					d[R] = d[now] + "R";
					q.add(R);
				}
				int D = 0;
				if(now*2 > 9999) {
					D = (now*2)%10000;
				} else {
					D = now*2;
				}
				if(check[D] == false) {
					q.add(D);
					d[D] = d[now] + "D"; 
					check[D] = true;
				}
				int S = 0;
				if(now-1 <= 0) {
					S = 9999;
				} else {
					S = now-1;
				}
				if(check[S] == false) {
					q.add(S);
					d[S] = d[now] + "S";
					check[S] = true;
				}
			}
			System.out.println(d[b]);
		}
	}

}
