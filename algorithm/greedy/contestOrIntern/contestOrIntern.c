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

    //// �Ʒ� �ڵ�� �������� �ϳ��� �����ϰ� ����(����, ���� ������ �ο� �� �� ����ؾ���)

    // int N, M, K;
    // scanf("%d %d %d", &N, &M, &K);
    // int ans = 0;
    // int r = 0; // �� ���� �� ���� �ο�
    
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

    // K = K - r; // ���� �ο� ���� ���ְ�

    // while(K>0) { // ���Ͻ��� �����ؾ� �� �л� �� �����ִٸ�
    //     if(ans<=0) {
    //         break;
    //     }
    //     ans--;
    //     K = K - 3;
    // }

    // printf("%d", ans);

    // return 0;
}