import java.util.*;

class Solution {
    class Page {
        int idx;
        int baseScore;
        int link;
        double score;
        
        public Page(int idx, int baseScore, int link, Double score) {
            this.idx = idx;
            this.baseScore = baseScore;
            this.link = link;
            this.score = score;
        }
    }
    class Comp implements Comparator<Page> { 
        public int compare(Page p1, Page p2) {
            if(p1.score == p2.score) {
                return p1.idx - p2.idx;
            } else if(p1.score < p2.score) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    public int solution(String word, String[] pages) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Page> listMap = new ArrayList<Page>();
        
        word = word.toLowerCase();
        for(int i=0; i<pages.length; i++) {
            String page = pages[i].toLowerCase();
            int left = 0, right = 0, startLink = 0;
            while(startLink<=left) {
                left = page.indexOf("<meta ", left+1);
                right = page.indexOf(">", left);
                startLink = page.lastIndexOf("https://", right);
            }
            right = page.indexOf("\"", startLink);
            String url = page.substring(startLink, right);
            
            left = page.indexOf("<body>", right);
            int baseScore = 0;
            for(int start=left; ;) {
                start = page.indexOf(word, start+1);
                if(start == -1) break;
                if(!Character.isLetter(page.charAt(start-1)) && !Character.isLetter(page.charAt(start + word.length() ))) {
                    baseScore++;
                    start += word.length();
                }
            }
            int link = 0;
            for(int start = left; ;) {
                start = page.indexOf("<a href", start+1);
                if(start == -1) break;
                link++;
            }
            map.put(url, i);
            listMap.add(new Page(i, baseScore, link, (double)baseScore));
        }
        for(int i=0; i<pages.length; i++) {
            String page = pages[i];
            
            for(int left = 0, right = 0; ;) {
                left = page.indexOf("<a href", right);
                if(left == -1) break;
                left = page.indexOf("https://", left);
                right = page.indexOf("\"", left);
                String url = page.substring(left, right);
                
                Integer matchIdx = map.get(url);
                if(matchIdx != null) {
                    listMap.get(matchIdx).score += (double)listMap.get(i).baseScore / listMap.get(i).link;   
                }
            }
        }
        listMap.sort(new Comp());
        int answer = listMap.get(0).idx;
        
        return answer;
    }
}