package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B_1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		Set<String> set = new HashSet<String>();
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		List<String> names = new ArrayList<String>();
		for(int i=0; i<m; i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				names.add(name);
			}
		}
		Collections.sort(names);
		StringBuilder ans = new StringBuilder();
		ans.append(names.size()).append('\n');
		for(String name : names) {
			ans.append(name).append('\n');
		}
		System.out.println(ans);
	}

}
