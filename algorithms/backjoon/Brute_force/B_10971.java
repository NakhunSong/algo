import java.util.Scanner;

public class Main {
	public static boolean next_permutation(int[] a) {
		int i = a.length-1;
		while(i>0 && a[i-1] >= a[i]) {
			i -= 1;
		}
		if(i <= 0) return false;
		
		int j = a.length-1;
		while(a[i-1] >= a[j]) {
			j -= 1;
		}
		int temp = a[j];
		a[j] = a[i-1];
		a[i-1] = temp;
		
		j = a.length-1;
		while(i<j) {
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] w = new int[n][n];
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = i;
		}
		int min = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				w[i][j] = sc.nextInt();
				min += w[i][j];
			}
		}
		do {
			boolean isLoad = true;
			int sum = 0;
			for(int i=1; i<n; i++) {
				int weight = w[a[i-1]][a[i]];
				if(weight == 0) {
					isLoad = false;
					break;
				} else {
					sum += weight;
				}
			}
			if(w[a[n-1]][a[0]] == 0) {
				isLoad = false;
			} else {
				sum += w[a[n-1]][a[0]];
			}
			
			if(isLoad) {
				min = Math.min(sum, min);
			}
		} while(next_permutation(a));
		System.out.println(min);
	}

}
