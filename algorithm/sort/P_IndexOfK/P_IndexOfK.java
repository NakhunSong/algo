import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		int[] result = new int[commands.length];
		for(int x=0; x<commands.length; x++) {
			int i = commands[x][0];
			int j = commands[x][1];
			int k = commands[x][2];
			int[] cuttedArray = new int[j-i+1];
			int index = 0;
			for(int y=i-1; y<j; y++) {
				cuttedArray[index++] = array[y];
			}
			Arrays.sort(cuttedArray);
			result[x] = cuttedArray[k-1];
		}
		answer = result;
		return answer;
    }
}