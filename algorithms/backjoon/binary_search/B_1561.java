import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] first = br.readLine().split(" ");
		String[] second = br.readLine().split(" ");
		long n = Long.valueOf(first[0]);
		int m = Integer.valueOf(first[1]);
		long[] a = new long[m];
		for(int i=0; i<m; i++) {
			a[i] = Long.valueOf(second[i]);
		}
		if(n<=m) {
			System.out.println(n);
			return;
		}
		long left = 0;
		long right = 2000000000L * 10000L;
		while(left<=right) {
			long mid = left + (right-left)/2;
			long begin = 0, end = 0;
			end = m; // Kids ride m rides at 0 minute in advance
			for(int i=0; i<m; i++) {
				end += mid/a[i];
			}
			begin = end;
			for(int i=0; i<m; i++) {
				if(mid%a[i] == 0) {
					begin -= 1; // want to 22 as end -> 20 as start but it will be 19  
				}
			}
			begin += 1; // so 19(as begin) +1 => 20
			
			if(begin > n) {
				right = mid -1;
			} else if(end < n) {
				left = mid + 1;
			} else {
				for(int i=0; i<m; i++) {
					if(mid % a[i] == 0) {
						if(begin == n) {
							System.out.println(i+1);
							return;
						}
						begin+=1;
					}
				}
			}
		}
	}

}
