import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for(int i=0; i<26; i++) {
			System.out.print(s.indexOf((char)(97+i)) + " ");
		}
	}

}
