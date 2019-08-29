import java.util.*;

public class Main {
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String start = "";
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				int temp = sc.nextInt();
				if(temp == 0) {
					temp = 9; 
				}
				start += temp;
			}
		}
		Map<String, Integer> map = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		map.put(start, 0);
		q.add(start);
		while(!q.isEmpty()) {
			String now = q.remove();
			int idx = now.indexOf('9');
			int x = idx/3;
			int y = idx%3;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<3 && ny>=0 && ny<3) {
					StringBuilder next = new StringBuilder(now);
					char tmp = next.charAt(x*3+y);
					next.setCharAt(x*3+y, next.charAt(nx*3+ny)); 
					next.setCharAt(nx*3+ny, tmp);
					if(!map.containsKey(next.toString())) {
						map.put(next.toString(), map.get(now)+1);
						q.add(next.toString());
					}
				}
			}
		}
		String target = "123456789";
		if(map.containsKey(target)) {
			System.out.println(map.get(target));
		} else {
			System.out.println("-1");
		}
	}

}
