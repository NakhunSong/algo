import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<number.length()-k; i++) {
            char max = '0';
            for(int j=start; j<=k+i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    start = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}