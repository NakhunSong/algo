import java.util.*;
import java.io.*;

public class Main {
	public static class Pair {
		int text;
		int bomb;
		Pair(int text, int bomb) {
			this.text = text;
			this.bomb = bomb;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String bomb = br.readLine();
		int n = text.length();
		int m = bomb.length();
		boolean[] check = new boolean[n];
		Stack<Pair> stack = new Stack<>();
		if(m == 1) {
			for(int i=0; i<n; i++) {
				if(text.charAt(i) == bomb.charAt(0)) {
					check[i] = true;
				}
			}
		} else {
			for(int i=0; i<n; i++) {
				if(text.charAt(i) == bomb.charAt(0)) {
					stack.add(new Pair(i, 0));
				} else {
					if(!stack.isEmpty()) {
						Pair top = stack.peek();
						if(text.charAt(i) == bomb.charAt(top.bomb+1)) {
							stack.add(new Pair(i, top.bomb+1));
							if(top.bomb+1 == m-1) {
								for(int k=0; k<m; k++) {
									Pair p = stack.pop();
									check[p.text] = true;
								}
							}
						} else {
							while(!stack.isEmpty()) {
								stack.pop();
							}
						}
					}
				}
			}
		}
		boolean isText = false;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			if(check[i]) {
				continue;
			}
			sb.append(text.charAt(i));
			isText = true;
		}
		if(isText) {
			System.out.println(sb);
		} else {
			System.out.println("FRULA");
		}
	}

}
