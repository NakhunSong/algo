import java.io.*;
import java.util.*;

public class Main {
	public static Set<Character> set = new HashSet<>();
	public static String[] a;
	public static boolean check(String word) {
		int moCnt = 0;
		for(int i=0; i<word.length(); i++) {
			if(set.contains(word.charAt(i))) {
				moCnt++;
			}
		}
		int zaCnt = word.length()-moCnt;
		return moCnt>=1 && zaCnt>=2;
	}
	public static void go(String word, int start, int c, int l) {
		if(word.length() == l) {
			if(check(word)) {
				System.out.println(word);
			}
			return;
		}
		if(start >= c) return;
		go(word+a[start], start+1, c, l);
		go(word, start+1, c, l);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] first = br.readLine().split(" ");
		int l = Integer.valueOf(first[0]);
		int c = Integer.valueOf(first[1]);
		a = br.readLine().split(" ");
		
		char[] mo = {'a', 'e', 'i', 'o', 'u'};
		for(int i=0; i<mo.length; i++) {
			set.add(mo[i]);
		}
		Arrays.sort(a);
		go("", 0, c, l);
	}

}
