#include <stdio.h>

int main() {

  //Please Enter Your Code Here
  int a, b;
  scanf("%d %d", &a, &b);
  
  int GCD;
  int LCM;
  int A = a;
  int B = b;
  
  while(1) {
    int r = a % b;
    
    if(r == 0) {
      GCD = b;
      break;
    }
    a = b;
    b = r;
  }
  
  LCM = GCD * A/GCD * B/GCD;

  printf("%d %d", GCD, LCM);
  
  return 0;
}