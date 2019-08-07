import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<String>();
		String[] cambridge = {"C", "A", "M", "B", "R", "I", "D", "G", "E"};
		for(String s : cambridge) {
			set.add(s);
		}
		String[] s = br.readLine().split("");
		List<String> list = new ArrayList<String>();
		for(int i=0; i<s.length; i++) {
			if(set.contains(s[i])) {
				continue;
			} else {
				list.add(s[i]);
			}
		}
		StringBuilder ans = new StringBuilder();
		for(String l : list) {
			ans.append(l);
		}
		System.out.println(ans);
	}

}
