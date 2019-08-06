import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int zero = 0;
		int one = 0;
		List<Integer> minus = new ArrayList<>();
		List<Integer> plus = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				zero++;
			} else if(num == 1) {
				one++;
			} else if(num < 0) {
				minus.add(num);
			} else {
				plus.add(num);
			}
		}
		Collections.sort(minus);
		Collections.sort(plus, Collections.reverseOrder());
		int sum = one;
		if(minus.size()%2 == 1) {
			minus.add(zero > 0 ? 0 : 1);
		}
		if(plus.size()%2 == 1) {
			plus.add(1);
		}
		for(int i=0; i<plus.size(); i+=2) {
			sum += plus.get(i) * plus.get(i+1);
		}
		for(int i=0; i<minus.size(); i+=2) {
			sum += minus.get(i) * minus.get(i+1);
		}
		System.out.println(sum);
	}

}
