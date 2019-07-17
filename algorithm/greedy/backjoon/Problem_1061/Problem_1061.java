import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String N = scan.nextLine();
		ArrayList<Integer> sorted = new ArrayList<Integer>();
        
        String input[] = N.split("");
        
		for(int i=0; i<input.length; i++) {
            int n = Integer.parseInt(input[i]);
            sum += n;
            sorted.add(n);
        }
        
        Collections.sort(sorted);
        if(sum%3 == 0 && sorted.get(0) == 0) {
            for(int i=sorted.size()-1; i>=0; i--) {
                System.out.println(sorted.get(i));
            }
        } else {
            System.out.println(-1);
        }

	}

}
