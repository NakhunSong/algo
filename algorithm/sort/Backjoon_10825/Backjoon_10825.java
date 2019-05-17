import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static class Student implements Comparable<Student> {
		String name;
		int kS;
		int eS;
		int mS;
		
		public Student(String name, int kS, int eS, int mS) {
			this.name = name;
			this.kS = kS;
			this.eS = eS;
			this.mS = mS;
		}
		
		@Override
		public int compareTo(Student s) {
			if(kS < s.kS) {
				return 1;
			} else if(kS == s.kS) {
				if(eS > s.eS) {
					return 1;
				} else if(eS == s.eS) {
					if(mS < s.mS) {
						return 1;
					} else if(mS == s.mS){
						return name.compareTo(s.name);
					}
				}
			}
			return -1;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String[] str = new String[4];
		List<Student> list = new ArrayList<Student>();
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			String name = str[0];
			int kS = Integer.parseInt(str[1]);
			int eS = Integer.parseInt(str[2]);
			int mS = Integer.parseInt(str[3]);
			list.add(new Student(name, kS, eS, mS));
		}
		Collections.sort(list);
		for(Student s : list) {
			System.out.println(s);
		}
	}

}
