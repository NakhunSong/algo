import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static class Album implements Comparable<Album>{
		String genre;
		int total;
		int plays;
		int idx;
		
		public Album(String genre, int total, int plays, int idx) {
			this.genre = genre;
			this.total = total;
			this.plays = plays;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Album a) {
			if(this.total < a.total) {
				return 1;
			} else if(this.total == a.total) {
				if(this.plays < a.plays) {
					return 1;
				} else if(this.plays == a.plays) {
					if(this.idx > this.idx) {
						return 1;
					}
				}
			}
			return -1;
		}
	}
    public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		Map<String, Integer> hm = new HashMap<String, Integer>(); 
		Map<String, Integer> hm2 = new HashMap<String, Integer>(); 
		
		int n = genres.length;
		List<Album> list = new ArrayList<Album>();
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			hm.put(genres[i], 2);
			Integer total = hm2.get(genres[i]);
			if(total == null) {
				hm2.put(genres[i], plays[i]);
			} else {			
				hm2.put(genres[i], total + plays[i]);	
			}
		}
		for(int i=0; i<n; i++) {
			int total = hm2.get(genres[i]);
			list.add(new Album(genres[i], total, plays[i], i));
		}
		Collections.sort(list);
		
		for(Album a : list) {
			if(hm.get(a.genre) != 0) {
				result.add(a.idx);
				hm.put(a.genre, hm.get(a.genre) - 1);
			} else {
				continue;
			}
		}
		
		answer = new int[result.size()];
		for(int i=0; i<result.size(); i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
    }
}