import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Point implements Comparable<Point> {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point p) {
			if(this.x > p.x) {
				return 1;
			} else if(this.x == p.x) {
				if(this.y > p.y) {
					return 1;
				}
			}
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		List<Point> pointList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			pointList.add(new Point(x, y));			
		}
		Collections.sort(pointList);
		for(Point p : pointList) {
			System.out.println(p.x + " " + p.y);
		}
	}

}
