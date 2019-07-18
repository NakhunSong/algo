#include <stdio.h>

int main() {
    int N, K;
    scanf("%d %d", &N, &K);

    int coin[N];

    for(int i=0; i<N; i++) {
        scanf("%d", &coin[i]);
    }
    int ans = 0;

    int i = N-1;
    while(K != 0) {
        if(K < coin[i]) {
            i--;
            continue;
        } else {
            while(1) {
                if(K < coin[i]) {
                    i--;
                    break;
                } else {
                    K = K - coin[i];
                    ans++;
                }
            }
        }
    }

    printf("%d", ans);
    
    return 0;
}