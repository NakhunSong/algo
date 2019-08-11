import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] numlist = new char[s.length()];
		for(int i=0; i<s.length(); i++) {
			numlist[i] = s.charAt(i);
		}
		Arrays.sort(numlist);
		
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=numlist.length-1; i>=0; i--) {
			sum += numlist[i]-'0';
			sb.append(numlist[i]);
		}
		if(numlist[0] == '0' && sum % 3 == 0) {
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

}
