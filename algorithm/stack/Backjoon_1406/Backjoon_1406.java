import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static Stack<Character> left = new Stack<Character>();
	static Stack<Character> right = new Stack<Character>();
	
	static public void command(String s) {
		if(s.contains("P")) {
			String[] p = s.split(" ");
			left.push(p[1].charAt(0));
		} else if(s.equals("L")){
			if(left.size()!=0) {
				right.push(left.pop());
			}
		} else if(s.equals("D")) {
			if(right.size()!=0) {
				left.push(right.pop());
			}
		} else if(s.equals("B")) {
			if(left.size()!=0) {
				left.pop();	
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String first = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		// 맨 처음 문자열 왼쪽 스택에 다 추가
		for(int i=0; i<first.length(); i++) {
			left.push(first.charAt(i));
		}
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			command(line);
		}

		int leftSize = left.size();
		
		for(int i=0; i<leftSize; i++) {
			right.push(left.pop());
		}
		
		int rightSize = right.size();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<rightSize; i++) {
			sb.append(right.pop());
		}
		System.out.println(sb);
	}

}
