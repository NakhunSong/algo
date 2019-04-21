#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    int start[N];
    int end[N];

    for(int i=0; i<N; i++) {
        scanf("%d", &start[i]);
        scanf("%d", &end[i]);
    }

    for(int i=0; i<N; i++) {
        int idx = i;
        for(int j=idx; j<N; j++) {
            if(end[idx] > end[j]) {
                idx = j;
            }
        }
        int temp;
        int temp2;
        temp = end[idx];
        end[idx] = end[i];
        end[i] = temp;
        temp2 = start[idx];
        start[idx] = start[i];
        start[i] = temp2;
    }

    int ans = 0;
    int prevEnd = 0;
    for(int i=0; i<N; i++) {
        if(prevEnd <= start[i]) {
            ans++;
            prevEnd = end[i];
        }
    }
    
    printf("%d", ans);

    return 0;
}