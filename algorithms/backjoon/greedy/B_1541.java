import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		List<Integer> num = new ArrayList<>();
		List<Integer> sign = new ArrayList<>();
		int curNum = 0;
		sign.add(1); // 맨처음은 양수
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '-' || c == '+') {
			 	if(c == '+') {
			 		sign.add(1);
			 	} else {
					sign.add(-1);
			 	}
			 	num.add(curNum);
			 	curNum = 0;
			} else {
				curNum = curNum * 10 + (c-'0');
			}
		}
		num.add(curNum); // 마지막 숫자
		boolean isMinus = false;
		int sum = 0;
		for(int i=0; i<num.size(); i++) {
			if(sign.get(i) == -1) {
				isMinus = true; // 첫 음수 나온 뒤로 계속 마이너스 유지
			}
			if(isMinus) {
				sum -= num.get(i); // 양수 음수 관계없이 마이너스 상태 시 뺄셈
			} else {
				sum += num.get(i);
			}
		}
		System.out.println(sum);
	}

}
