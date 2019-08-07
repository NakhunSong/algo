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
			if(y > p.y) {
				return 1;
			} else if(y == p.y) {
				if(x > p.x) {
					return 1;
				}
			}
			return -1;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Point> list = new ArrayList<Point>();
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new Point(x, y));
		}
		Collections.sort(list);
		for(Point p : list) {
			System.out.println(p.x + " " + p.y);
		}
	}

}
