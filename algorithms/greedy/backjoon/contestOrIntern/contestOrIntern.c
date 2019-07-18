#include <stdio.h>

int main() {
    int N, M, K, max=0, rN, rM, R;
    int ans;
    scanf("%d %d %d", &N, &M, &K);
    max = (N / 2) < M ? (N / 2) : M;
    
    rN = N - max * 2, rM = M - max;
    R = rN+rM;
    if(R>=K) {
        ans = max;
    } else {
        if((K-R) % 3 == 0) {
            max -= (K-R)/3;
        } else {
            max -= (K-R)/3 + 1;
        }
        if(max<0) {
            ans = 0;
        } else {
            ans = max;
        }
    }

    printf("%d", ans);

    //// 아래 코드는 나머지를 하나만 생각하고 구함(여자, 남자 나머지 인원 둘 다 고려해야함)

    // int N, M, K;
    // scanf("%d %d %d", &N, &M, &K);
    // int ans = 0;
    // int r = 0; // 팀 구성 후 남는 인원
    
    // while(N >= 2 && M >=1) {
    //     N = N - 2;
    //     M = M - 1;
    //     ans++;
    //     if(N == 0 || M == 0) {
    //         if(M != 0) {
    //             r = M;
    //         } else if(N != 0) {
    //             r = N;
    //         }
    //         break;
    //     }
    // }

    // K = K - r; // 남는 인원 먼저 빼주고

    // while(K>0) { // 인턴쉽에 참여해야 할 학생 수 남아있다면
    //     if(ans<=0) {
    //         break;
    //     }
    //     ans--;
    //     K = K - 3;
    // }

    // printf("%d", ans);

    // return 0;
}