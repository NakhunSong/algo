import java.util.Scanner;

public class Main {
	public static void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length-1);
	}
	public static void quicksort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		if(start < part2-1) {
			quicksort(arr, start, part2-1);			
		}
		if(part2 < end) {
			quicksort(arr, part2, end);
		}
		
	}
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start+end)/2];
		while(start<=end) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot) end--;
			if(start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
	}
	public static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		quicksort(arr);
		for(int data : arr) {
			System.out.println(data);
		}
	}

}
