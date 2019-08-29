class Solution {
    public static int check(String word) {
		if(!word.matches("[a-z|A-Z|0-9]*")) {
			return -1;
		}
		int s = 0;
		int n = 0;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(c-'9' > 0) {
				s++;
			} else {
				n++;
			}
		}
		if(s%2==1 || n%2==0) {
			return -1;
		}
		
		return s+n;
	}
    public int solution(String S) {
		String[] a = S.split(" ");
		int max = -1;
		for(int i=0; i<a.length; i++) {
			max = Math.max(max, check(a[i]));
		}
		return max;
    }
}