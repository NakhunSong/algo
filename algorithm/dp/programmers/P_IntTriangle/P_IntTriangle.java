class Solution {
  public int solution(int[][] triangle) {
      int answer = 0;
      int n = triangle.length;
      int[][] d = new int[n][n];
      d[0][0] = triangle[0][0];
  for(int i=1; i<n; i++) {
    for(int j=0; j<=i; j++) {
      if(j-1>=0) {
        d[i][j] = d[i-1][j-1] + triangle[i][j];
      }
      if(j<i) {
        if(d[i][j] < d[i-1][j]+triangle[i][j]) d[i][j] = d[i-1][j] + triangle[i][j]; 
      }
    }
  }
  answer = d[n-1][0];
  for(int i=1; i<n; i++) {
    answer = Math.max(answer, d[n-1][i]);
  }
      return answer;
  }
}