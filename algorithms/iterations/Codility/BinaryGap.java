import java.util.ArrayList;
import java.util.List;

public class BinaryGap {
	public static int Solution(int n) {
		int answer = 0;
		String result = "";
		result = Integer.toBinaryString(n);
		int last = 0;
		int gap = 0;
		for(int i=0; i<result.length(); i++) {
			int num = result.charAt(i)-'0';
			if(num == 1) {
				if(i - last > gap) {
					gap = i - last;
				}
				last = i;
			}
			answer = gap;
		}
//		System.out.println(answer);
		if(answer-1 < 0) {
			answer = 0;
		} else {
			answer = answer -1;
		}
		return answer;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(Solution(51712));
	}

}