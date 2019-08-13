import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = i+1;
		}
		if(N>=(M+K-1) && N<=M*K) {
			N -= K;
			M -= 1;
			int delem = M == 0 ? 1 : N/M;
			int r = M == 0 ? 1 : N%M;
        
			List<Integer> list = new ArrayList<>();
			list.add(0);
			list.add(K);
			for(int i=0; i<M; i++) {
				int next = list.get(list.size()-1) + delem + (r>0 ? 1 : 0);
				list.add(next);
				if(r > 0) r-=1;
			}
			for(int i=0; i<list.size()-1; i++) {
				int start = list.get(i);
				int end = list.get(i+1)-1;
				while(start < end) {
					int temp = A[start];
					A[start] = A[end];
					A[end] = temp;
					start++;
					end--;
				}
			}
			for(int i=0; i<A.length; i++) {
				System.out.println(A[i] + " ");
			}
		} else {
			System.out.println(-1);
		}
	}

}
