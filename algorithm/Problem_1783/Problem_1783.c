#include <stdio.h>

int main() {
    int N, M;
    scanf("%d %d", &N, &M);
    int ans;

    if(N==1) {
        ans = 1;
    } else if(N==2) {
        if(M>7) {
            ans = 4;
        } else {
            ans = (M+1)/2;
        }
    } else if(N>=3) {
        if(M>=7) {
            ans = M - 2;
        } else {
            if(M>4) {
                ans = 4;
            } else {
                ans = M;
            }
        }
    }
    printf("%d", ans);
    
    return 0;
}