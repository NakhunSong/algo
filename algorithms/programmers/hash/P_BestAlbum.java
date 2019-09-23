import java.util.*;

class Solution {
    static class Music implements Comparable<Music>{
        int index;
        int play;
        int genre;
        public Music(int index, int play, int genre) {
            this.index = index;
            this.play = play;
            this.genre = genre;
        }
        
        @Override
        public int compareTo(Music m) {
            if(this.genre < m.genre) {
                return 1;
            } else if(this.genre == m.genre) {
                if(this.play < m.play) {
                    return 1;
                } else if(this.play == m.play) {
                    if(this.index > m.index) {
                        return 1;
                    }
                }
            }
            return -1;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        Map<String, Integer> genreCnt = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(genreCnt.get(genres[i]) == null) {
                genreCnt.put(genres[i], plays[i]);
            } else {
                genreCnt.put(genres[i], genreCnt.get(genres[i])+plays[i]);
            }
        }
        List<Music> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new Music(i, plays[i], genreCnt.get(genres[i])));
        }
        Collections.sort(list);
        Map<String, Integer> limit = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            int playIdx = list.get(i).index;
            String genre = genres[playIdx];
            if(limit.get(genre) == null) {
                limit.put(genre, 1);
                ans.add(playIdx);
            } else if(limit.get(genre) < 2) {
                limit.put(genre, 2);
                ans.add(playIdx);
            }
        }
        int index = 0;
        int[] answer = new int[ans.size()];
        for(int a : ans) {
            answer[index++] = a;
        }
        return answer;
    }
}

// pre
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