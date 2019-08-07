import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			String[] s = new String[2];
			String str = sc.nextLine();
			s = str.split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[0] == b[0]) {
					return Integer.compare(a[1], b[1]);
				}
				return Integer.compare(a[0], b[0]);
			}
		});
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}

}
