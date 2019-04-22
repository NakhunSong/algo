#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);
    
    int withdraw[N];
    int waitingTime[N];
    int sum = 0;
    int ans = 0;

    for(int i=0; i<N; i++) {
        scanf("%d", &withdraw[i]);
    }

    for(int i=0; i<N; i++) {
        for(int j=0; j<N-1-i; j++) {
            if(withdraw[j] > withdraw[j+1]) {
                int temp;
                temp = withdraw[j];
                withdraw[j] = withdraw[j+1];
                withdraw[j+1] = temp;
            }
        }
    }

    for(int i=0; i<N; i++) {
        waitingTime[i] = sum + withdraw[i];
        sum = sum + withdraw[i];
    }
    
    for(int i=0; i<N; i++) {
        ans = ans + waitingTime[i];
    }

    printf("%d", ans);
    
    return 0;
}