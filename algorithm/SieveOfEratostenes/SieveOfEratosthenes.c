//�����佺�׳׽��� ü
#include <stdio.h>

int main() {
  
  int n;
  scanf("%d", &n);
  int prime[n];
  
  // ��� ���� �Ҽ��� ����
  for(int i=2; i<=n; i++) {
    prime[i] = 1;
  }
  
  // �Ҽ��� �ƴ� ���� ����
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