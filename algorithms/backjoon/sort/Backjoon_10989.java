import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[100001];
		for(int i=0; i<n; i++) {			
			cnt[Integer.parseInt(br.readLine())] += 1;			
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=10000; i++) {
			if(cnt[i] > 0) {
				for(int j=0; j<cnt[i]; j++) { // 반복된 숫자 반복 출력 시키기 위해서 필요
					bw.write(Integer.toString(i)+"\n");
				}
			}
		}
		br.close();
		bw.close();
	}

}
