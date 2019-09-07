import java.util.*;

class Solution {
	public static Map<String, String> map = new HashMap<>();
	public static List<String> list = new ArrayList<>();
    public static void doing(String line){
        String[] s = line.split(" ");
        if(s[0].equals("Enter")){
            map.put(s[1], s[2]);
        } else if(s[0].equals("Change")){
            map.put(s[1], s[2]);
        }
    }
    public static String printing(String line){
        String[] s = line.split(" ");
        if(s[0].equals("Enter")){
            return map.get(s[1])+"님이 들어왔습니다.";
        } else if(s[0].equals("Leave")) {
        	return map.get(s[1])+"님이 나갔습니다.";
        }
        return "";
    }
    public String[] solution(String[] record) {
        for(String r : record){
            doing(r);
        }
        for(String r : record){
        	String result = printing(r);
        	if(!result.equals("")) {
        		list.add(result);        		
        	}
        }
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}