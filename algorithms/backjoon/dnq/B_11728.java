import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] A = new int[N];
		int[] B = new int[M];
		String[] astring = br.readLine().split(" ");
		String[] bstring = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(astring[i]);
		}
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(bstring[i]);
		}
		int[] C = new int[N+M];
		int aIdx = 0;
		int bIdx = 0;
		int cIdx = 0;
		while(aIdx < N || bIdx < M) {
			if(bIdx>=M || (aIdx<N && A[aIdx] <= B[bIdx])) {
				C[cIdx++] = A[aIdx++];
			} else {
				C[cIdx++] = B[bIdx++];
			} 
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N+M; i++) {
			sb.append(C[i] + " ");
		}
		System.out.println(sb);
	}

}
