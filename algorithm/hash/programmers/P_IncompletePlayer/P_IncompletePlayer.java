import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		int n = participant.length;
		for(int i=0; i<n; i++) {
			if(i == n-1) {
				answer = participant[i];
			} else if(participant[i] != completion[i]) {
				answer = participant[i];
				break;
			}
		}
		return answer;
    }
}