import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		TreeSet<String> set = new TreeSet<>();
		for(int i=0; i<n; i++) {
			String[] s = sc.nextLine().split(" ");
			if(s[1].equals("enter")) {
				set.add(s[0]);
			} else {
				set.remove(s[0]);
			}
		}
		NavigableSet<String> reverseSet = set.descendingSet();
		Iterator<String> iter = reverseSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
