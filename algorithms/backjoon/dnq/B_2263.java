import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[] in;
	public static int[] post;
	public static int[] position;
	public static StringBuilder sb = new StringBuilder();
	public static void getPreOrderRoot(int inS, int inE, int postS, int postE) {
		if(inS>inE || postS>postE) {
			return;
		}
		int root = post[postE];
		sb.append(root +" ");
		int inRoot = position[root];
		int left = inRoot - inS;
		getPreOrderRoot(inS, inRoot-1, postS, postS+left-1); // 왼쪽
		getPreOrderRoot(inRoot+1, inE, postS+left , postE-1); // 오른쪽
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		String[] sIn = br.readLine().split(" ");
		String[] sPost = br.readLine().split(" ");
		in = new int[n];
		post = new int[n];
		for(int i=0; i<n; i++) {
			in[i] = Integer.valueOf(sIn[i]);
			post[i] = Integer.valueOf(sPost[i]);
		}
		position = new int[n+1];
		for(int i=0; i<n; i++) {
			position[in[i]] = i;
		}
		getPreOrderRoot(0, n-1, 0, n-1);
		System.out.println(sb);
	}

}
