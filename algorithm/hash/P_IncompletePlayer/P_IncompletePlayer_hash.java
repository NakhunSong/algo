import java.util.HashMap;
import java.util.Map;

public String Solution(String[] participant, String[] completion) {
    String answer = "";
    Map<String, Integer> hm = new HashMap<>();
    
    for(int i=0; i<participant.length; i++) { 
        if(hm.get(participant[i]) == null) {
            hm.put(participant[i], 1);
        } else {
            int cnt = hm.get(participant[i]) + 1; // 중복 경우 1 추가
            hm.put(participant[i], cnt);
        }
    }
    for(int i=0; i<completion.length; i++) {
        int cnt = hm.get(completion[i])-1;
        hm.put(completion[i], cnt);
    }
    for(String key : hm.keySet()) {
        if(hm.get(key) == 1) {
            answer = key;
        }
    }
    return answer;
}