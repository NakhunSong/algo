import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<Integer> list = new ArrayList<>();
	public static void go(int[] a, int index, int count) {
		if(count == 6) {
			for(int l : list) {
				System.out.print(l + " ");
			}
			System.out.println();
			return;
		}
		if(index == a.length) return;
		list.add(a[index]);
		go(a, index+1, count+1);
		list.remove(list.size()-1);
		go(a, index+1, count);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			int[] a = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			go(a, 0, 0);
			System.out.println();
		}
	}

}
