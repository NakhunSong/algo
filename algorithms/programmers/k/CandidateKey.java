import java.util.*;
class Solution {
    public static ArrayList<Integer> list = new ArrayList<>();
	public static boolean check(int now) {
		for(int i=0; i<list.size(); i++) {
			if((list.get(i)&now) == list.get(i)){
				return false;
			}
		}
		return true;
	}
    public int solution(String[][] relation) {
        int answer = 0;
		int n = relation.length;
		int m = relation[0].length;
		for(int k=1; k<(1<<m); k++) {
			Set<String> set = new HashSet<>();
			for(int i=0; i<n; i++) {
				String now = "";
				for(int j=0; j<m; j++) {
					if((k&(1<<j)) > 0) {
						now += relation[i][j];
					}
				}
				set.add(now);
			}
			if(set.size() == n && check(k)) {
				list.add(k);
			}
		}
        answer = list.size();
		return answer;
    }
}