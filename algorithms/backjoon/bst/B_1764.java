// 832 ms
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		Set<String> set = new HashSet<>();
		TreeSet<String> treeSet = new TreeSet<>();
		for(int i=0; i<n; i++) {
			set.add(sc.nextLine());
		}
		int cnt = 0;
		for(int i=0; i<m; i++) {
			String s = sc.nextLine();
			if(set.contains(s)) {
				treeSet.add(s);
				cnt++;
			}
		}
		System.out.println(cnt);
		Iterator<String> iter = treeSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}

// 384ms
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] first = br.readLine().split(" ");
		int n = Integer.valueOf(first[0]);
		int m = Integer.valueOf(first[1]);
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			map.put(s, 1);
		}
		for(int i=0; i<m; i++) {
			String s = br.readLine();
			if(map.get(s) == null){
				map.put(s, 1);
			} else {
				map.put(s, map.get(s)+1);
			}
		}
		ArrayList<String> list = new ArrayList<>();
		for(String key : map.keySet()) {
			if(map.get(key) >= 2) {
				list.add(key);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(String l : list) {
			System.out.println(l);
		}
	}

}
