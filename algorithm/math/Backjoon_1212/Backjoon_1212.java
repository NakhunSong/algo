import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] e = {"000", "001", "010", "011", "100", "101", "110", "111"};
		String s = sc.nextLine();
		String ans = "";
		boolean first = true;
		if (s.length() == 1 && s.charAt(0) == '0') {
			System.out.print(0);
        }
		for(int i=0; i<s.length(); i++) {
			int num = s.charAt(i)-'0';
			if(num<4 && first) {
				if(num == 0) {
					continue;
				} else if(num == 1) {
//					ans += "1";
					System.out.print("1");
				} else if(num == 2) {
//					ans += "10";
					System.out.print("10");
				} else if(num == 3) {
//					ans += "11";
					System.out.print("11");
				}
			} else {
//				ans += e[num];
				System.out.print(e[num]);
			}
			first = false;
			
		}
		System.out.println(ans);
	}

}
