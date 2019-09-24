import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] a = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            a[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(a, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        if(a[0].equals("0")) {
            return "0";
        }
        answer = String.join("", a);
        return answer;
    }
}

// pre
class Solution {
    public String solution(int[] numbers) {
		String answer = "";
		String[] sNumbers = new String[numbers.length];
		for(int i=0; i<numbers.length; i++) {
			sNumbers[i] = Integer.toString(numbers[i]);
		}
		Arrays.sort(sNumbers, (a, b) -> (b+a).compareTo(a+b));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<sNumbers.length; i++) {
			if(sNumbers[0].equals("0")) return "0";
			sb.append(sNumbers[i]);
		}
		answer = sb.toString();
		return answer;
    }
}