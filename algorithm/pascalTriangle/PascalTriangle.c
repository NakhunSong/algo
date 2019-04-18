#include <stdio.h>

int main() {

  //Please Enter Your Code Here
  int arr[100][100] = {0}, n;
  scanf("%d", &n);
  arr[1][n] = 1;
  for(int i=2; i<=n; i++) {
    for(int j=1; j<=n*2; j++) {
      arr[i][j] = arr[i-1][j-1] + arr[i-1][j+1];
    }
  }
  
  for(int i=1; i<=n; i++) {
    for(int j=1; j<=n*2; j++) {
      if(arr[i][j] == 0) {
        printf("x ");
      } else {
        printf("%d ", arr[i][j]);
      }
    }
    printf("\n");
  }

  return 0;
}