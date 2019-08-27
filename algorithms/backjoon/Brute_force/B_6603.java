import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static boolean next_permutation(int[] a) {
		int i = a.length - 1;
		while(i>0 && a[i-1] >= a[i]) {
			i -= 1;
		}
		if(i <= 0) return false;
		
		int j = a.length - 1;
		while(a[i-1] >= a[j]) {
			j -= 1;
		}
		int temp = a[j];
		a[j] = a[i-1];
		a[i-1] = temp;
		
		j = a.length - 1;
		while(i < j) {
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int k = sc.nextInt();
			if(k == 0) {
				break;
			}
			int[] a = new int[k];
			for(int i=0; i<k; i++) {
				a[i] = sc.nextInt();
			}
			int[] d = new int[k];
			for(int i=0; i<k-6; i++) {
				d[i] = 0;
			}
			for(int i=k-6; i<k; i++) {
				d[i] = 1;
			}
			ArrayList<ArrayList<Integer>> file = new ArrayList<ArrayList<Integer>>();
			do {
				ArrayList<Integer> record = new ArrayList<>();
				for(int i=0; i<k; i++) {
					if(d[i] == 1) {
						record.add(a[i]);
					}
				}
				file.add(record);
			} while(next_permutation(d));
			for(int i=file.size()-1; i>=0; i--) {
				for(int j=0; j<file.get(i).size(); j++) {
					System.out.print(file.get(i).get(j) + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}

}
