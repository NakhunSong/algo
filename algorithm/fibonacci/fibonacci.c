#include <stdio.h>

int fibonacci(int n) {
    int number[3] = {0, 1, 1};
    for(int i=2; i<N; i++) {
        number[(i+1)%3] = number[i%3] + number[(i-1)%3];
    }
    return number[n%3];
}

int main() {
    int N;
    scanf("%d", &N);
    int ans = fibonacci(N);

    printf("%d", ans);
    
    return 0;
}