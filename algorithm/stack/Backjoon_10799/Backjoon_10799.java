package backjoon;

import java.util.Scanner;
import java.util.Stack;

public class Backjoon_10799 {
	static Scanner sc = new Scanner(System.in);
	static int ans = 0;
	public static void main(String[] args) {
		String s = sc.nextLine();
		String[] a = s.split("");
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<a.length; i++) {
			if(a[i].equals("(")) {
				stack.push(i);
			} else if(a[i].equals(")")) {
				int num = stack.pop();
				if(i - num == 1) {
					ans += stack.size();
				} else {
					ans += 1;	
				}
			}
		}
		
		System.out.println(ans);
	}

}
