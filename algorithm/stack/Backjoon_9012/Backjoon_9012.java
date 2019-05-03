import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    
	static int N;
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> VPS = new ArrayList<String>();
	
	public static void main(String[] args) {
		N = scan.nextInt();
		scan.nextLine();
		String[] vps = new String[N];
		for(int i=0; i<N; i++) {
			String s = scan.nextLine();
			vps[i] = s;
		}
		
		for(int i=0; i<vps.length; i++) {
			Stack<Character> stack = new Stack<Character>();
			boolean fail = false;
			
			for(int j=0; j<vps[i].length(); j++) {
				
				if(vps[i].charAt(j) == '(') {
					stack.push(vps[i].charAt(j));
				} else if(vps[i].charAt(j) == ')') {
					if(stack.isEmpty()) {
						fail = true;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if(fail == false && stack.isEmpty()) {
				VPS.add("YES");
			} else {
				VPS.add("NO");
			}
		}
		
		for(int i=0; i<VPS.size(); i++) {
			System.out.println(VPS.get(i));
		}
	}

}
