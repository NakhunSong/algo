import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static class Pair implements Comparable<Pair> {
		int start;
		int end;
		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
		public int compareTo(Pair p) {
			if(this.end > p.end) {
				return 1;
			} else if(this.end == p.end) { // end 같은 경우 시작시간도 비교정렬해서 (2,2) (1,2) 중 뒤의 회의 count 안되는 것 방지.
				if(this.start > p.start) {
					return 1;
				}
			}
			return -1;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.valueOf(br.readLine());
		ArrayList<Pair> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			list.add(new Pair(start, end));
		}
		Collections.sort(list);
		int conferenceCnt = 1;
		int end = list.get(0).end;
		for(int i=1; i<list.size(); i++) {
			Pair thisConference = list.get(i);
			// if(thisConference.start > end) { // 같은 것도 count.
			if(thisConference.start >= end) {
				end = thisConference.end;
				conferenceCnt++;
			}
		}
		System.out.println(conferenceCnt);
	}

}
