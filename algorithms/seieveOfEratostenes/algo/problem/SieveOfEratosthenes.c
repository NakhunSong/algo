//에라토스테네스의 체
#include <stdio.h>

int main() {
  
  int n;
  scanf("%d", &n);
  int prime[n];
  
  // 모든 수를 소수라 가정
  for(int i=2; i<=n; i++) {
    prime[i] = 1;
  }
  
  // 소수가 아닌 수들 지움
  for(int i=2; i<=n; i++) {
    if(prime[i] == 1) {
      for(int j=i*2; j<=n; j++) {
        if(j%i == 0) {
          prime[j] = 0;
        }
      }
    }
  }
  
  for(int i=2; i<=n; i++) {
    if(prime[i] == 1) {
      printf("%d ", i);
    } else {
      printf("x ");
    }
  }

  return 0;
}