import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String formula = scan.nextLine();
		String[] numbers = formula.split("-");
		
		ArrayList<Integer> number = new ArrayList<Integer>();
		int ans;
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i].contains("+")) {
				String[] algs = numbers[i].split("\\+");
				int sum = 0;
				for(int j=0; j<algs.length; j++) {
					sum += Integer.parseInt(algs[j]);
					
				}
				number.add(sum);
			} else {
				int n = Integer.parseInt(numbers[i]);
				number.add(n);
			}
			
		}
		ans = number.get(0);
		for(int i=1; i<number.size(); i++) {
			ans = ans - number.get(i);
		}
		System.out.println(ans);

	}

}
