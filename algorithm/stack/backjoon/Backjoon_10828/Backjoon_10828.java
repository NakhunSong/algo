import java.util.ArrayList;
import java.util.Scanner;

class Stack {
	class Node {
		private int data;
		private Node next;
		
		Node(int daTa) {
			this.data = daTa;
		}
	}
	private Node top;
	
	public void push(int data) {
		Node n = new Node(data);
		if(top == null) {
			top = n;
		} else {
			n.next = top;
			top = n;
		}
	}
	
	public int pop() {
		int result = 0;
		if(top == null) {
			result = -1;
		} else {
			result = top.data;
			top = top.next;
		}
		return result;
	}
	
	public int size() {
		int cnt = 0;
		Node temp = top;
		while(true) {
			if(temp == null) {
				break;
			}
			cnt++;
			
			temp = temp.next;
		}
		return cnt;
	}
	
	public int empty() {
		return (top==null) ? 1 : 0;
	}
	
	public int top() {
		return (top == null) ? -1 : top.data;
	}
	
	
}
public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static ArrayList<Integer> result;
	
	public static void main(String[] args) {
		N = sc.nextInt();
		sc.nextLine();
		result = new ArrayList<Integer>();
		Stack stack = new Stack();
		for(int i=0; i<N; i++) {
			String s = sc.nextLine();
			if(s.contains("push")) {
				String[] p = s.split(" ");
				int num = Integer.parseInt(p[1]);
				stack.push(num);
			} else if(s.equals("pop")) {
				result.add(stack.pop());
			} else if(s.equals("size")) {
				result.add(stack.size());
			} else if(s.equals("empty")) {
				result.add(stack.empty());
			} else if(s.equals("top")) {
				result.add(stack.top());
			}
			
		}
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
